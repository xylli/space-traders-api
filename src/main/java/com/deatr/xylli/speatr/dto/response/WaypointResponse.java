package com.deatr.xylli.speatr.dto.response;

import com.deatr.xylli.speatr.dto.SymbolObject;
import com.deatr.xylli.speatr.dto.types.WaypointTrait;
import com.deatr.xylli.speatr.dto.types.WaypointType;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import org.springframework.validation.annotation.Validated;

import java.util.List;

public record WaypointResponse(
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

        @Validated
        public record Trait(
                @NotNull String name,
                @NotNull String description,
                @NotNull WaypointTrait symbol
        ) {}

        @Validated
        public record Chart(
                String waypointSymbol,
                String submittedBy,
                String submittedOn //date-time
        ) {}
}
