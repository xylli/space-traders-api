package com.deatr.xylli.speatr.dto.data;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

@Valid
public record Extraction(
        @NotBlank String shipSymbol,
        @NotNull ExtractionYield yield
) {

    @Valid
    public record ExtractionYield(
            @NotBlank String symbol,
            int units
    ) {
    }
}
