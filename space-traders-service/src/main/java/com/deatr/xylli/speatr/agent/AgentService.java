package com.deatr.xylli.speatr.agent;

import com.deatr.speatr.api.GlobalApi;
import com.deatr.xylli.speatr.infra.DataService;
import com.deatr.xylli.speatr.infra.ModifyingMethod;
import com.deatr.xylli.speatr.util.ValidationUtils;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RequiredArgsConstructor
@DataService
public class AgentService {
    private final GlobalApi globalApi;
    private final AgentRepository agentRepository;


    @ModifyingMethod
    public void createAgent(AgentCreationRequest agentCreationRequest) {
        var response = globalApi.registerWithHttpInfo(agentCreationRequest.toRegisterRequest()).block();
        if (response == null || response.getStatusCode().isError()) {
            log.error("Could not register agent: {}", response != null ? response.getBody() : null);
            throw ValidationUtils.internalServerErrorException("Could not register agent");
        }
        if (response.getBody() != null) {
            var body = response.getBody().getData();
            var entity = new Agent();
            log.info("Registered new agent '{}' with access token '{}'", agentCreationRequest, body.getToken());
            entity.setFaction(agentCreationRequest.faction());
            entity.setSymbol(agentCreationRequest.symbol());
            entity.setEmail(agentCreationRequest.email());
            entity.setToken(body.getToken());
            agentRepository.save(entity);
        } else {
            throw ValidationUtils.internalServerErrorException("Could not register agent, response body is null");
        }
    }
}
