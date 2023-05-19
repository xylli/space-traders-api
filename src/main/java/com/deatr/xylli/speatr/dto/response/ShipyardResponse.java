package com.deatr.xylli.speatr.dto.response;

import com.deatr.xylli.speatr.dto.data.*;
import com.deatr.xylli.speatr.dto.types.ShipType;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;

import java.time.LocalDateTime;
import java.util.List;

public record ShipyardResponse(
        @NotBlank
        String symbol,
        @NotNull
        List<ShipTypeObj> shipTypes,
        @NotNull
        List<ShipyardTransaction> transactions,
        @NotNull
        List<ShipyardShip> ships

) {

    public record ShipTypeObj(
            @NotNull ShipType type
    ) {
    }

    public record ShipyardTransaction(
            @NotBlank String waypointSymbol,
            @NotBlank String shipSymbol,
            @Positive int price,
            @NotBlank String agentSymbol,
            @NotNull LocalDateTime timestamp
    ) {
    }

    public record ShipyardShip(
            @NotNull ShipType type,
            @NotNull String name,
            @NotNull String description,
            @Positive int purchasePrice,
            @NotNull ShipFrame frame,
            @NotNull ShipReactor reactor,
            @NotNull ShipEngine engine,
            @NotNull List<ShipModule> modules,
            @NotNull List<ShipMount> mounts
    ) {
    }
}
