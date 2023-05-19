package com.deatr.xylli.speatr.dto.response;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;

@Valid
public record AgentResponse(
        @NotBlank
        String accountId,
        @NotBlank
        String symbol,
        @NotBlank
        String headquarters,
        long credits
) {
}
