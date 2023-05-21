package com.deatr.xylli.speatr.dto.data;

import com.deatr.xylli.speatr.dto.types.SystemType;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.util.List;

@Valid
public record JumpGate(
        int jumpRange,
        String factionSymbol,
        @NotNull List<ConnectedSystem> connectedSystems
) {

    @Valid
    public record ConnectedSystem(
            @NotBlank String symbol,
            @NotBlank String sectorSymbol,
            @NotNull SystemType type,
            String factionSymbol,
            int x,
            int y,
            int distance
    ) {
    }
}
