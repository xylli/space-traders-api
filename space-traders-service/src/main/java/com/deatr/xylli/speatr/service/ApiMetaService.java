package com.deatr.xylli.speatr.service;

import com.deatr.speatr.api.AgentsApi;
import com.deatr.xylli.speatr.client.MetaClient;
import com.deatr.xylli.speatr.dto.response.StatusResponse;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@Slf4j
public class ApiMetaService {
    private final MetaClient metaClient;
    private final AgentsApi agentsApi;

/*    public Mono<RegisterNewAgentResponse> registerNewAgent(@Nullable SpaceTradersApiProperties.RegistrationProperties registration) {
        RegisterNewAgentRequest request = Optional.ofNullable(registration)
                .map(it -> new RegisterNewAgentRequest(it.faction(), it.name(),it.email()))
                .orElse(RegisterNewAgentRequest.random());
        return metaClient.registerNewAgent(request).map(DataWrapper::data);
    }*/

    public StatusResponse getStatus() {
        return metaClient.status();
    }
}
