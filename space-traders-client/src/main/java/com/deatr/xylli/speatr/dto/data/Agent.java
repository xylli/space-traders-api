package com.deatr.xylli.speatr.dto.data;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;

@Valid
public record Agent(
        @NotBlank
        String accountId,
        @NotBlank
        String symbol,
        @NotBlank
        String headquarters,
        long credits
) {
}
