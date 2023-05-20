package com.deatr.xylli.speatr.dto.response;

import com.deatr.xylli.speatr.dto.data.Agent;
import com.deatr.xylli.speatr.dto.data.ship.ShipFuel;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;


@Valid
public record RefuelResponse(
        @NotNull Agent agent,
        @NotNull ShipFuel fuel
) {

}
