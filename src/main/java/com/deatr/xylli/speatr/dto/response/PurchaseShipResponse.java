package com.deatr.xylli.speatr.dto.response;

import com.deatr.xylli.speatr.dto.data.ship.Ship;
import com.deatr.xylli.speatr.dto.data.ship.ShipyardTransaction;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;

@Valid
public record PurchaseShipResponse(
        @NotNull AgentResponse agent,
        @NotNull Ship ship,
        @NotNull ShipyardTransaction transaction
) {
}
