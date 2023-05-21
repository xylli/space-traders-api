package com.deatr.xylli.speatr.dto.response;

import com.deatr.xylli.speatr.dto.data.Cooldown;
import com.deatr.xylli.speatr.dto.data.scan.ScannedShip;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;

import java.util.List;

@Valid
public record ScanShipsResponse(
        @NotNull Cooldown cooldown,
        @NotNull List<ScannedShip> ships
) {

}
