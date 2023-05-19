package com.deatr.xylli.speatr.dto.request;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;

@Valid
public record NavigateRequest(
        @NotBlank String waypointSymbol
) {
}
