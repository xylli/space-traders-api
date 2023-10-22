package com.deatr.xylli.speatr.dto.data;

import com.deatr.xylli.speatr.dto.data.ship.*;
import com.deatr.xylli.speatr.dto.types.ShipType;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;

import java.util.List;

@Valid
public record Shipyard(
        @NotBlank
        String symbol,
        @NotNull
        List<ShipTypeObj> shipTypes,
        @NotNull
        List<ShipyardTransaction> transactions,
        @NotNull
        List<ShipyardShip> ships

) {

    @Valid
    public record ShipTypeObj(
            @NotNull ShipType type
    ) {
    }

    @Valid
    public record ShipyardShip(
            @NotNull ShipType type,
            @NotNull String name,
            @NotNull String description,
            @Positive int purchasePrice,
            @NotNull ShipFrame frame,
            @NotNull ShipReactor reactor,
            @NotNull ShipEngine engine,
            @NotNull List<ShipModule> modules,
            @NotNull List<ShipMount> mounts,
            @NotNull ShipyardCrew crew
    ) {
    }

    public record ShipyardCrew(@Positive int required, @Positive int capacity) {

    }
}
