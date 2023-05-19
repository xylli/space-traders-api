package com.deatr.xylli.speatr.dto.data;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.PositiveOrZero;

import java.util.List;

public record ShipMount(
        @NotNull ShipMountType symbol,
        @NotNull String name,
        @NotNull String description,
        @PositiveOrZero int strength,
        @NotNull List<ShipMountDeposit> deposits,
        @NotNull ShipRequirements requirements
) {

    public enum ShipMountType {
        MOUNT_GAS_SIPHON_I,
        MOUNT_GAS_SIPHON_II,
        MOUNT_GAS_SIPHON_III,
        MOUNT_SURVEYOR_I,
        MOUNT_SURVEYOR_II,
        MOUNT_SURVEYOR_III,
        MOUNT_SENSOR_ARRAY_I,
        MOUNT_SENSOR_ARRAY_II,
        MOUNT_SENSOR_ARRAY_III,
        MOUNT_MINING_LASER_I,
        MOUNT_MINING_LASER_II,
        MOUNT_MINING_LASER_III,
        MOUNT_LASER_CANNON_I,
        MOUNT_MISSILE_LAUNCHER_I,
        MOUNT_TURRET_I
    }

    public enum ShipMountDeposit {
        QUARTZ_SAND,
        SILICON_CRYSTALS,
        PRECIOUS_STONES,
        ICE_WATER,
        AMMONIA_ICE,
        IRON_ORE,
        COPPER_ORE,
        SILVER_ORE,
        ALUMINUM_ORE,
        GOLD_ORE,
        PLATINUM_ORE,
        DIAMONDS,
        URANITE_ORE,
        MERITIUM_ORE
    }
}
