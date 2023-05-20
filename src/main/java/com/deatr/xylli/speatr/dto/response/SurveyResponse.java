package com.deatr.xylli.speatr.dto.response;

import com.deatr.xylli.speatr.dto.data.Cooldown;
import com.deatr.xylli.speatr.dto.data.Survey;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;

import java.util.List;

@Valid
public record SurveyResponse(
        @NotNull Cooldown cooldown,
        @NotNull List<Survey> surveys
) {

}
