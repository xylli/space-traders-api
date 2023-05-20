package com.deatr.xylli.speatr.dto.data.ship;

import com.deatr.xylli.speatr.dto.types.FlightMode;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;

@Valid
public record ShipNav(
        @NotNull String systemSymbol,
        @NotNull String waypointSymbol,
        @NotNull ShipNavRoute route,
        @NotNull ShipNavStatus status,
        @NotNull FlightMode flightMode
) {

    public enum ShipNavStatus {
        IN_TRANSIT,
        IN_ORBIT,
        DOCKED
    }
}
