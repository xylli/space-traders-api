package com.deatr.xylli.speatr.client;

import com.deatr.xylli.speatr.dto.response.AgentResponse;
import com.deatr.xylli.speatr.dto.DataWrapper;
import org.springframework.web.service.annotation.GetExchange;

public interface AgentClient {

    @GetExchange("/my/agent")
    DataWrapper<AgentResponse> getMyAgent();

}
