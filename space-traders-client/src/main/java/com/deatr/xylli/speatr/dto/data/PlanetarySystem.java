package com.deatr.xylli.speatr.dto.data;

import com.deatr.xylli.speatr.dto.SymbolObject;
import com.deatr.xylli.speatr.dto.types.SystemType;
import com.deatr.xylli.speatr.dto.types.WaypointType;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.util.List;

@Valid
public record PlanetarySystem(
        @NotBlank
        String symbol,
        @NotBlank
        String sectorSymbol,
        @NotNull
        SystemType type,
        int x,
        int y,
        List<Waypoint> waypoints,
        List<SymbolObject> factions
) {

    @Valid
    public record Waypoint(
            @NotBlank
            String symbol,
            @NotNull
            WaypointType type,
            int x,
            int y
    ) {}
}
