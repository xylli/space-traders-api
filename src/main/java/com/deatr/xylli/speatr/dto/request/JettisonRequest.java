package com.deatr.xylli.speatr.dto.request;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;

@Valid
public record JettisonRequest(
        @NotNull String symbol,
        @Positive int units
) {
}
