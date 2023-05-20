package com.deatr.xylli.speatr.dto.response;

import com.deatr.xylli.speatr.dto.data.Cooldown;
import com.deatr.xylli.speatr.dto.data.Extraction;
import com.deatr.xylli.speatr.dto.data.ship.ShipCargo;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;

@Valid
public record ExtractResponse(
        @NotNull Cooldown cooldown,
        @NotNull Extraction extraction,
        @NotNull ShipCargo cargo
) {
}
