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
        String orbits,
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

        public boolean isTrait(WaypointTrait trait) {
            return this.symbol.equals(trait);
        }
    }

    public boolean isType(WaypointType type) {
        return this.type.equals(type);
    }

    public boolean hasTrait(WaypointTrait trait) {
        return this.traits.stream()
                .anyMatch(it -> it.isTrait(trait));
    }

}
