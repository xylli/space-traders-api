package com.deatr.xylli.speatr.service;

import com.deatr.xylli.speatr.client.MetaClient;
import com.deatr.xylli.speatr.config.SpaceTradersApiProperties;
import com.deatr.xylli.speatr.dto.request.RegisterNewAgentRequest;
import com.deatr.xylli.speatr.dto.response.RegisterNewAgentResponse;
import com.deatr.xylli.speatr.dto.response.StatusResponse;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@Slf4j
public class ApiMetaService {
    private final MetaClient metaClient;

    public RegisterNewAgentResponse registerNewAgent(SpaceTradersApiProperties.RegistrationProperties registration) {
        return metaClient.registerNewAgent(new RegisterNewAgentRequest(
                registration.faction(),
                registration.name(),
                registration.email()
        )).data();
    }

    public StatusResponse getStatus() {
        return metaClient.status();
    }
}
