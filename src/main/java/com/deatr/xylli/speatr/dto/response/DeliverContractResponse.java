package com.deatr.xylli.speatr.dto.response;

import com.deatr.xylli.speatr.dto.data.Contract;
import com.deatr.xylli.speatr.dto.data.ship.ShipCargo;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;

@Valid
public record DeliverContractResponse(
    @NotNull Contract contract,
    @NotNull ShipCargo cargo
) {

}
