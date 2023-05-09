package com.deatr.xylli.speatr.dto.response;

import com.deatr.xylli.speatr.dto.SymbolObject;
import com.deatr.xylli.speatr.dto.types.SystemType;
import com.deatr.xylli.speatr.dto.types.WaypointType;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import org.springframework.validation.annotation.Validated;

import java.util.List;

@Validated
public record SystemResponse(
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

    @Validated
    public record Waypoint(
            @NotBlank
            String symbol,
            @NotNull
            WaypointType type,
            int x,
            int y
    ) {}
}
