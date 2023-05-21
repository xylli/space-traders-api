package com.deatr.xylli.speatr.dto.data.scan;

import com.deatr.xylli.speatr.dto.types.SystemType;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

@Valid
public record ScannedSystem(
        @NotBlank String symbol,
        @NotBlank String sectorSymbol,
        @NotNull SystemType type,
        int x,
        int y,
        int distance
) {

}
