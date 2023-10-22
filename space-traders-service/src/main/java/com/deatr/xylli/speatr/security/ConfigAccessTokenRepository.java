package com.deatr.xylli.speatr.security;

import com.deatr.xylli.speatr.config.AppProperties;
import com.deatr.xylli.speatr.exception.SpaceTradersApiException;
import com.deatr.xylli.speatr.service.ApiMetaService;
import com.deatr.xylli.speatr.util.ValidationUtils;
import jakarta.annotation.Nullable;
import jakarta.annotation.PostConstruct;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Mono;


@Repository("config")
@Slf4j
@RequiredArgsConstructor
public class ConfigAccessTokenRepository implements AccessTokenRepository {

    private final AppProperties appProperties;
    private final ApiMetaService apiMetaService;
    @Nullable
    private String accessToken = null;

    @PostConstruct
    public void init() {
        var token = appProperties.spaceTradersApi().accessToken();
        if (token == null || accessTokenIsExpired()) {
            token = registerNewAgent();
        }
        this.accessToken = token;
    }

    private boolean accessTokenIsExpired() {
        var tokenResetDate = appProperties.spaceTradersApi().getAccessTokenResetDate()
                .orElseThrow(ValidationUtils.configurationExceptionSupplier("Could not resolve the reset date for the configured access token"));
        var lastServerResetDate = apiMetaService.getStatus().resetDate();
        return tokenResetDate.isBefore(lastServerResetDate);
    }

    private String registerNewAgent() {
        var registrationProperties = appProperties.spaceTradersApi().registration();
        try {
            var newAgent = apiMetaService.registerNewAgent(registrationProperties);
            log.info("Registered new agent '{}' with access token '{}'", newAgent.agent().accountId(), newAgent.token());
            return newAgent.token();
        } catch (SpaceTradersApiException e) {
            throw ValidationUtils.configurationExceptionSupplier("Error while registering agent", e).get();
        }
    }

    @Override
    public Mono<String> loadAccessToken() {
        return Mono.justOrEmpty(accessToken);
    }
}
