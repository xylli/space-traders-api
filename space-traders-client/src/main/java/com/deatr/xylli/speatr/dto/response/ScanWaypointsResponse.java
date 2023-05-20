package com.deatr.xylli.speatr.dto.response;

import com.deatr.xylli.speatr.dto.SymbolObject;
import com.deatr.xylli.speatr.dto.data.Chart;
import com.deatr.xylli.speatr.dto.data.Cooldown;
import com.deatr.xylli.speatr.dto.types.WaypointTrait;
import com.deatr.xylli.speatr.dto.types.WaypointType;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.util.List;

@Valid
public record ScanWaypointsResponse(
        @NotNull Cooldown cooldown,
        @NotNull List<ScannedWaypoint> waypoints
) {

    @Valid
    public record ScannedWaypoint(
            @NotBlank String symbol,
            @NotNull WaypointType type,
            @NotBlank String systemSymbol,
            int x,
            int y,
            @NotNull List<SymbolObject> orbitals,
            @NotNull SymbolObject faction,
            @NotNull List<WaypointTrait> traits,
            @NotNull Chart chart
    ) {

    }

}
