package com.deatr.xylli.speatr.dto.response;

import com.deatr.xylli.speatr.dto.types.SystemType;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.util.List;

public record JumpGateResponse(
        int jumpRange,
        String factionSymbol,
        @NotNull List<ConnectedSystem> connectedSystems
) {

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
