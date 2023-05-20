package com.deatr.xylli.speatr.dto.request;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;

@Valid
public record TransferCargoRequest(
        @NotNull String tradeSymbol,
        int units,
        @NotNull String shipSymbol
) {
}
