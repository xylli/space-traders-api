package com.deatr.xylli.speatr.client;

import com.deatr.xylli.speatr.dto.DataListWrapper;
import com.deatr.xylli.speatr.dto.DataWrapper;
import com.deatr.xylli.speatr.dto.response.SystemResponse;
import com.deatr.xylli.speatr.dto.response.WaypointResponse;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Positive;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.service.annotation.GetExchange;

@Validated
public interface SystemClient {

    @GetExchange("/systems")
    DataListWrapper<SystemResponse> getSystems(
            @RequestParam @Positive @Max(20) int limit,
            @RequestParam @Positive int page
    );

    @GetExchange("/systems/{systemSymbol}")
    DataWrapper<SystemResponse> getSystem(
            @PathVariable
            String systemSymbol
    );

    @GetExchange("/systems/{systemSymbol}/waypoints")
    DataListWrapper<WaypointResponse> getWaypoints(
            @RequestParam @Positive @Max(20) int limit,
            @RequestParam @Positive int page,
            @PathVariable String systemSymbol
    );

}
