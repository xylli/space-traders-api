package com.deatr.xylli.speatr.security;

import com.deatr.xylli.speatr.config.AppProperties;
import com.deatr.xylli.speatr.dto.response.RegisterNewAgentResponse;
import com.deatr.xylli.speatr.exception.SpaceTradersApiException;
import com.deatr.xylli.speatr.service.ApiMetaService;
import com.deatr.xylli.speatr.util.ValidationUtils;
import jakarta.annotation.PostConstruct;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Mono;

import java.time.LocalDate;


@Repository("config")
@Slf4j
@RequiredArgsConstructor
public class ConfigAccessTokenRepository implements AccessTokenRepository {

    private final AppProperties appProperties;
    private final ApiMetaService apiMetaService;
    private CachedAccessToken accessToken = CachedAccessToken.empty();
    private  LocalDate lastServerResetDate = LocalDate.MIN;

    @PostConstruct
    public void init() {
        String token = appProperties.spaceTradersApi().accessToken();
        if (token != null) {
            accessToken = new CachedAccessToken(token);
        }
        lastServerResetDate = apiMetaService.getStatus().resetDate();
    }

    private boolean accessTokenIsExpired() {
        var tokenResetDate = accessToken.expiration();

        return tokenResetDate.isBefore(lastServerResetDate);
    }

    private Mono<String> registerNewAgent() {
        var registrationProperties = appProperties.spaceTradersApi().registration();
        try {
            var newAgent = apiMetaService.registerNewAgent(registrationProperties);
            return newAgent.doOnSuccess(it -> {
                accessToken = new CachedAccessToken(it.token());
                log.info("Registered new agent '{}' with access token '{}'", it.agent().accountId(), it.token());
            }).map(RegisterNewAgentResponse::token);
        } catch (SpaceTradersApiException e) {
            throw ValidationUtils.configurationExceptionSupplier("Error while registering agent", e).get();
        }
    }

    @Override
    public Mono<String> loadAccessToken() {
        if (accessToken.isEmpty() || accessTokenIsExpired()) {
            return registerNewAgent();
        }
        return Mono.justOrEmpty(accessToken.token());
    }
}
