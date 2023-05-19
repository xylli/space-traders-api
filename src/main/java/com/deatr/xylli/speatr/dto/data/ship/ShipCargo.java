package com.deatr.xylli.speatr.dto.data.ship;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.PositiveOrZero;

import java.util.List;

@Valid
public record ShipCargo(
        @PositiveOrZero int capacity,
        @PositiveOrZero int units,
        @NotNull List<ShipCargoItem> inventory
) {
}
