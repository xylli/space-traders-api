package com.deatr.xylli.speatr.dto.data.ship;

import jakarta.validation.Valid;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.PositiveOrZero;

@Valid
public record ShipFrame(
        @NotNull ShipFrameType symbol,
        @NotNull String name,
        @NotNull String description,
        @PositiveOrZero @Max(100) int condition,
        @PositiveOrZero int moduleSlots,
        @PositiveOrZero int mountingPoints,
        @PositiveOrZero int fuelCapacity,
        @NotNull ShipRequirements requirements
) {

    public enum ShipFrameType {
        FRAME_PROBE,
        FRAME_DRONE,
        FRAME_INTERCEPTOR,
        FRAME_RACER,
        FRAME_FIGHTER,
        FRAME_FRIGATE,
        FRAME_SHUTTLE,
        FRAME_EXPLORER,
        FRAME_MINER,
        FRAME_LIGHT_FREIGHTER,
        FRAME_HEAVY_FREIGHTER,
        FRAME_TRANSPORT,
        FRAME_DESTROYER,
        FRAME_CRUISER,
        FRAME_CARRIER
    }

}
