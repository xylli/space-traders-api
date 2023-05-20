package com.deatr.xylli.speatr.dto.data.ship;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.PositiveOrZero;

import java.time.LocalDateTime;

@Valid
public record ShipFuel(
        @PositiveOrZero int current,
        @PositiveOrZero int capacity,
        ConsumedFuel consumed
) {

    @Valid
    public record ConsumedFuel(
            @PositiveOrZero int amount,
            @NotNull LocalDateTime timestamp
    ) {

    }
}
