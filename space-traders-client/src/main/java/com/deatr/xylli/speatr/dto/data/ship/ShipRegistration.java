package com.deatr.xylli.speatr.dto.data.ship;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

@Valid
public record ShipRegistration(
        @NotBlank String name,
        @NotBlank String factionSymbol,
        @NotNull ShipRole role
) {

    public enum ShipRole {
        FABRICATOR,
        HARVESTER,
        HAULER,
        INTERCEPTOR,
        EXCAVATOR,
        TRANSPORT,
        REPAIR,
        SURVEYOR,
        COMMAND,
        CARRIER,
        PATROL,
        SATELLITE,
        EXPLORER,
        REFINERY
    }
}
