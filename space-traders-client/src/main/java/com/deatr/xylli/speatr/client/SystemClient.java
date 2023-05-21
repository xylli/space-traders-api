package com.deatr.xylli.speatr.client;

import com.deatr.xylli.speatr.dto.DataListWrapper;
import com.deatr.xylli.speatr.dto.DataWrapper;
import com.deatr.xylli.speatr.dto.data.*;
import com.deatr.xylli.speatr.dto.data.System;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Positive;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.service.annotation.GetExchange;

import static com.deatr.xylli.speatr.util.ApiConstants.FIRST_PAGE;
import static com.deatr.xylli.speatr.util.ApiConstants.LIST_REQUEST_LIMIT;

@Validated
public interface SystemClient {

    @GetExchange("/systems")
    DataListWrapper<System> getSystems(
            @RequestParam @Positive @Max(LIST_REQUEST_LIMIT) int limit,
            @RequestParam @Positive int page
    );

    @GetExchange("/systems/{systemSymbol}")
    DataWrapper<System> getSystem(
            @PathVariable
            @NotBlank String systemSymbol
    );
    default DataListWrapper<Waypoint> getFirstWaypointPage(String systemSymbol) {
        return getWaypoints(LIST_REQUEST_LIMIT, FIRST_PAGE, systemSymbol);
    }

    @GetExchange("/systems/{systemSymbol}/waypoints")
    DataListWrapper<Waypoint> getWaypoints(
            @RequestParam @Positive @Max(LIST_REQUEST_LIMIT) int limit,
            @RequestParam @Positive int page,
            @PathVariable @NotBlank String systemSymbol
    );

    @GetExchange("/systems/{systemSymbol}/waypoints/{waypointSymbol}")
    DataWrapper<Waypoint> getWaypoint(
            @PathVariable @NotBlank String systemSymbol,
            @PathVariable @NotBlank String waypointSymbol
    );

    @GetExchange("/systems/{systemSymbol}/waypoints/{waypointSymbol}/market")
    DataWrapper<Market> getMarket(
            @PathVariable @NotBlank String systemSymbol,
            @PathVariable @NotBlank String waypointSymbol
    );

    @GetExchange("/systems/{systemSymbol}/waypoints/{waypointSymbol}/shipyard")
    DataWrapper<Shipyard> getShipyard(
            @PathVariable @NotBlank String systemSymbol,
            @PathVariable @NotBlank String waypointSymbol
    );

    @GetExchange("/systems/{systemSymbol}/waypoints/{waypointSymbol}/jump-gate")
    DataWrapper<JumpGate> getJumpGate(
            @PathVariable @NotBlank String systemSymbol,
            @PathVariable @NotBlank String waypointSymbol
    );

}
