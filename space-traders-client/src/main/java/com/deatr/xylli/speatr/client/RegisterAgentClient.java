package com.deatr.xylli.speatr.client;

import com.deatr.xylli.speatr.dto.DataWrapper;
import com.deatr.xylli.speatr.dto.data.Agent;
import com.deatr.xylli.speatr.dto.request.RegisterNewAgentRequest;
import com.deatr.xylli.speatr.dto.response.RegisterNewAgentResponse;
import jakarta.validation.constraints.NotNull;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.service.annotation.GetExchange;
import org.springframework.web.service.annotation.PostExchange;

@Validated
public interface RegisterAgentClient {

    @PostExchange("/register")
    DataWrapper<RegisterNewAgentResponse> registerNewAgent(
            @RequestBody @NotNull RegisterNewAgentRequest body
    );

}
