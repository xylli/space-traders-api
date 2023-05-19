package com.deatr.xylli.speatr.dto.request;

import com.deatr.xylli.speatr.dto.types.ShipType;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;

@Valid
public record PurchaseShipRequest(
        @NotNull ShipType shipType,
        @NotNull String waypointSymbol
) {
}
