package com.deatr.xylli.speatr.dto.response;

import com.deatr.xylli.speatr.dto.data.Agent;
import com.deatr.xylli.speatr.dto.data.MarketTransaction;
import com.deatr.xylli.speatr.dto.data.ship.ShipCargo;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;


@Valid
public record PurchaseCargoResponse(
        @NotNull Agent agent,
        @NotNull ShipCargo cargo,
        @NotNull MarketTransaction transaction
) {

}
