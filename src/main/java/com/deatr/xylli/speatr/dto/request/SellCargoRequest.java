package com.deatr.xylli.speatr.dto.request;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;

@Valid
public record SellCargoRequest(
        @NotNull String symbol,
        int units
) {
}
