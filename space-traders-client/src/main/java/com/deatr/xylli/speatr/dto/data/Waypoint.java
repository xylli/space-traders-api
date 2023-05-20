package com.deatr.xylli.speatr.dto.data;

import com.deatr.xylli.speatr.dto.SymbolObject;
import com.deatr.xylli.speatr.dto.types.WaypointTrait;
import com.deatr.xylli.speatr.dto.types.WaypointType;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.util.List;

@Valid
public record Waypoint(
        @NotBlank
        String symbol,
        @NotNull
        WaypointType type,
        @NotBlank
        String systemSymbol,
        int x,
        int y,
        List<SymbolObject> orbitals,
        SymbolObject faction,
        List<Trait> traits,
        Chart chart
) {

    @Valid
    public record Trait(
            @NotNull String name,
            @NotNull String description,
            @NotNull WaypointTrait symbol
    ) {
    }

}
