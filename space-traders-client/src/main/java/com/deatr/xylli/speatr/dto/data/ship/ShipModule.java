package com.deatr.xylli.speatr.dto.data.ship;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.PositiveOrZero;

@Valid
public record ShipModule(
        @NotNull ShipModuleType symbol,
        @PositiveOrZero int capacity,
        @PositiveOrZero int range,
        @NotNull String name,
        @NotNull String description,
        @NotNull ShipRequirements requirements
) {

    public enum ShipModuleType {
        MODULE_MINERAL_PROCESSOR_I,
        MODULE_CARGO_HOLD_I,
        MODULE_CARGO_HOLD_II,
        MODULE_CARGO_HOLD_III,
        MODULE_CREW_QUARTERS_I,
        MODULE_ENVOY_QUARTERS_I,
        MODULE_PASSENGER_CABIN_I,
        MODULE_MICRO_REFINERY_I,
        MODULE_ORE_REFINERY_I,
        MODULE_FUEL_REFINERY_I,
        MODULE_SCIENCE_LAB_I,
        MODULE_WARP_DRIVE_I,
        MODULE_WARP_DRIVE_II,
        MODULE_WARP_DRIVE_III,
        MODULE_SHIELD_GENERATOR_I,
        MODULE_SHIELD_GENERATOR_II,
        MODULE_GAS_PROCESSOR_I,
    }
}
