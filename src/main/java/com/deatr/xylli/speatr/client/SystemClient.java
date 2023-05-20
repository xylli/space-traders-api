package com.deatr.xylli.speatr.client;

import com.deatr.xylli.speatr.dto.DataListWrapper;
import com.deatr.xylli.speatr.dto.DataWrapper;
import com.deatr.xylli.speatr.dto.data.Waypoint;
import com.deatr.xylli.speatr.dto.response.*;
import com.deatr.xylli.speatr.dto.data.System;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Positive;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.service.annotation.GetExchange;

@Validated
public interface SystemClient {

    @GetExchange("/systems")
    DataListWrapper<System> getSystems(
            @RequestParam @Positive @Max(20) int limit,
            @RequestParam @Positive int page
    );

    @GetExchange("/systems/{systemSymbol}")
    DataWrapper<System> getSystem(
            @PathVariable
            @NotBlank String systemSymbol
    );

    @GetExchange("/systems/{systemSymbol}/waypoints")
    DataListWrapper<Waypoint> getWaypoints(
            @RequestParam @Positive @Max(20) int limit,
            @RequestParam @Positive int page,
            @PathVariable @NotBlank String systemSymbol
    );

    @GetExchange("/systems/{systemSymbol}/waypoints/{waypointSymbol}")
    DataWrapper<Waypoint> getWaypoint(
            @PathVariable @NotBlank String systemSymbol,
            @PathVariable @NotBlank String waypointSymbol
    );

    @GetExchange("/systems/{systemSymbol}/waypoints/{waypointSymbol}/market")
    DataWrapper<MarketResponse> getMarket(
            @PathVariable @NotBlank String systemSymbol,
            @PathVariable @NotBlank String waypointSymbol
    );

    @GetExchange("/systems/{systemSymbol}/waypoints/{waypointSymbol}/shipyard")
    DataWrapper<ShipyardResponse> getShipyard(
            @PathVariable @NotBlank String systemSymbol,
            @PathVariable @NotBlank String waypointSymbol
    );

    @GetExchange("/systems/{systemSymbol}/waypoints/{waypointSymbol}/jump-gate")
    DataWrapper<JumpGateResponse> getJumpGate(
            @PathVariable @NotBlank String systemSymbol,
            @PathVariable @NotBlank String waypointSymbol
    );

}
