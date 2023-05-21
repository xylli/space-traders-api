package com.deatr.xylli.speatr.dto.request;

import com.deatr.xylli.speatr.dto.types.RefineProduceType;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;

@Valid
public record RefineRequest(
        @NotNull RefineProduceType produce
) {
}
