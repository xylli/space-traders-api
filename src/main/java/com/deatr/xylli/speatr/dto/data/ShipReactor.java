package com.deatr.xylli.speatr.dto.data;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.PositiveOrZero;

public record ShipReactor(
        @NotNull ReactorType type,
        @NotNull String name,
        @NotNull String description,
        @PositiveOrZero @Max(100) int condition,
        @Positive int powerOutput,
        @NotNull ShipRequirements requirements
) {

    public enum ReactorType {
        REACTOR_SOLAR_I,
        REACTOR_FUSION_I,
        REACTOR_FISSION_I,
        REACTOR_CHEMICAL_I,
        REACTOR_ANTIMATTER_I
    }

}
