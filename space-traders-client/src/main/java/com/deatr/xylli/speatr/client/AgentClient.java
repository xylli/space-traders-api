package com.deatr.xylli.speatr.client;

import com.deatr.xylli.speatr.dto.data.SpeatrAgent;
import com.deatr.xylli.speatr.dto.DataWrapper;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.service.annotation.GetExchange;

@Validated
public interface AgentClient {

    @GetExchange("/my/agent")
    DataWrapper<SpeatrAgent> getMyAgent();

}
