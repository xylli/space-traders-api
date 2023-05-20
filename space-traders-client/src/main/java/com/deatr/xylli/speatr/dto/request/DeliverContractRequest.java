package com.deatr.xylli.speatr.dto.request;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;

@Valid
public record DeliverContractRequest(
        @NotNull String shipSymbol,
        @NotNull String tradeSymbol,
        int units
) {
}
