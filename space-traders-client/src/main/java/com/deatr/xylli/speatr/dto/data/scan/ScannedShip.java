package com.deatr.xylli.speatr.dto.data.scan;

import com.deatr.xylli.speatr.dto.SymbolObject;
import com.deatr.xylli.speatr.dto.data.ship.ShipNav;
import com.deatr.xylli.speatr.dto.data.ship.ShipRegistration;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.util.List;

@Valid
public record ScannedShip(
        @NotBlank String symbol,
        @NotBlank ShipRegistration registration,
        @NotNull ShipNav nav,
        @NotNull SymbolObject frame,
        @NotNull SymbolObject reactor,
        @NotNull SymbolObject engine,
        @NotNull List<SymbolObject> mounts
) {
}
