package com.deatr.xylli.speatr.dto.data.ship;

import com.deatr.xylli.speatr.dto.data.Cooldown;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.util.List;

@Valid
public record Ship(
        @NotBlank String symbol,
        @NotNull ShipRegistration registration,
        @NotNull ShipNav nav,
        @NotNull ShipCrew crew,
        @NotNull ShipFrame frame,
        @NotNull ShipReactor reactor,
        @NotNull ShipEngine engine,
        @NotNull Cooldown cooldown,
        @NotNull List<ShipModule> modules,
        @NotNull List<ShipMount> mounts,
        @NotNull ShipCargo cargo,
        @NotNull ShipFuel fuel
) {
}
