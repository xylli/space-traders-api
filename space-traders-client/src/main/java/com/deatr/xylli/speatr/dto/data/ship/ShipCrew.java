package com.deatr.xylli.speatr.dto.data.ship;

import jakarta.validation.Valid;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.PositiveOrZero;

@Valid
public record ShipCrew(
        int current,
        int required,
        int capacity,
        @NotNull Rotation rotation,
        @PositiveOrZero @Max(100) int morale,
        @PositiveOrZero int wages
) {

    public enum Rotation {
        STRICT, RELAXED
    }
}
