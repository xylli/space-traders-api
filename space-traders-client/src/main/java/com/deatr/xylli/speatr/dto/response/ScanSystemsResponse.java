package com.deatr.xylli.speatr.dto.response;

import com.deatr.xylli.speatr.dto.data.Cooldown;
import com.deatr.xylli.speatr.dto.data.scan.ScannedSystem;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;

import java.util.List;

@Valid
public record ScanSystemsResponse(
        @NotNull Cooldown cooldown,
        @NotNull List<ScannedSystem> systems
) {

}
