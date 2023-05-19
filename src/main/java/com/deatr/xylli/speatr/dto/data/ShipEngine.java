package com.deatr.xylli.speatr.dto.data;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.PositiveOrZero;

public record ShipEngine(
    @NotNull ShipEngineType symbol,
    @NotNull String name,
    @NotNull String description,
    @PositiveOrZero @Max(100) int condition,
    @Positive int speed,
    @NotNull ShipRequirements requirements
) {

    public enum ShipEngineType {
        ENGINE_IMPULSE_DRIVE_I,
        ENGINE_ION_DRIVE_I,
        ENGINE_ION_DRIVE_II,
        ENGINE_HYPER_DRIVE_I
    }
}
