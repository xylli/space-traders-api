package com.deatr.xylli.speatr.dto.response;

import com.deatr.xylli.speatr.dto.data.ship.ShipNav;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;

@Valid
public record OrbitResponse(
        @NotNull ShipNav nav
) {
}
