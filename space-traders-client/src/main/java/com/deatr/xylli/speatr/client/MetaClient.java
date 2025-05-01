package com.deatr.xylli.speatr.client;

import com.deatr.xylli.speatr.dto.DataWrapper;
import com.deatr.xylli.speatr.dto.request.RegisterNewAgentRequest;
import com.deatr.xylli.speatr.dto.response.RegisterNewAgentResponse;
import com.deatr.xylli.speatr.dto.response.StatusResponse;
import jakarta.validation.constraints.NotNull;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.service.annotation.GetExchange;
import org.springframework.web.service.annotation.PostExchange;
import reactor.core.publisher.Mono;

@Validated
public interface MetaClient {

    @PostExchange("/register")
    Mono<DataWrapper<RegisterNewAgentResponse>> registerNewAgent(
            @RequestBody @NotNull RegisterNewAgentRequest body
    );

    @GetExchange("/")
    StatusResponse status();

}
