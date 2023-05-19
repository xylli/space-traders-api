package com.deatr.xylli.speatr.dto.response;

import com.deatr.xylli.speatr.dto.data.Cooldown;
import com.deatr.xylli.speatr.dto.data.ship.ShipCargo;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;

import java.util.List;

@Valid
public record ShipRefineResponse(
        @NotNull ShipCargo cargo,
        @NotNull Cooldown cooldown,
        @NotNull List<RefineItem> produced,
        @NotNull List<RefineItem> consumed
) {

    public record RefineItem(
            String tradeSymbol,
            int units
    ) {

    }
}
