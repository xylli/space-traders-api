package com.deatr.xylli.speatr.dto.request;

import com.deatr.xylli.speatr.dto.data.Survey;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;

@Valid
public record ExtractRequest(
        @NotNull Survey survey
) {
}
