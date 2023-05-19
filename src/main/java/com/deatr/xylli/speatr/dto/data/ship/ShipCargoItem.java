package com.deatr.xylli.speatr.dto.data.ship;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;

@Valid
public record ShipCargoItem(
        @NotNull String symbol,
        @NotNull String name,
        @NotNull String description,
        @Positive int units
) {
}
