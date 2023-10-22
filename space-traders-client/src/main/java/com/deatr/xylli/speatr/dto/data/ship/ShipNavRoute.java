package com.deatr.xylli.speatr.dto.data.ship;

import com.deatr.xylli.speatr.dto.types.WaypointType;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.time.LocalDateTime;

public record ShipNavRoute(
    @NotNull ShipNavRouteWaypoint destination,
    @NotNull ShipNavRouteWaypoint origin,
    @NotNull LocalDateTime departureTime,
    @NotNull LocalDateTime arrival
) {
    public record ShipNavRouteWaypoint(
            @NotBlank String symbol,
            @NotNull WaypointType type,
            @NotBlank String systemSymbol,
            int x,
            int y
    ) {
    }

}
