package com.deatr.xylli.speatr.service;

import com.deatr.xylli.speatr.client.MetaClient;
import com.deatr.xylli.speatr.config.SpaceTradersApiProperties;
import com.deatr.xylli.speatr.dto.DataWrapper;
import com.deatr.xylli.speatr.dto.request.RegisterNewAgentRequest;
import com.deatr.xylli.speatr.dto.response.RegisterNewAgentResponse;
import com.deatr.xylli.speatr.dto.response.StatusResponse;
import jakarta.annotation.Nullable;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

import java.util.Optional;

@Service
@RequiredArgsConstructor
@Slf4j
public class ApiMetaService {
    private final MetaClient metaClient;

    public Mono<RegisterNewAgentResponse> registerNewAgent(@Nullable SpaceTradersApiProperties.RegistrationProperties registration) {
        RegisterNewAgentRequest request = Optional.ofNullable(registration)
                .map(it -> new RegisterNewAgentRequest(it.faction(), it.name(),it.email()))
                .orElse(RegisterNewAgentRequest.random());
        return metaClient.registerNewAgent(request).map(DataWrapper::data);
    }

    public StatusResponse getStatus() {
        return metaClient.status();
    }
}
