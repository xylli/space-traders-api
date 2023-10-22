package com.deatr.xylli.speatr.dto.request;

import com.deatr.xylli.speatr.dto.SymbolObject;
import com.deatr.xylli.speatr.dto.data.DepositSize;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;

import java.time.LocalDateTime;
import java.util.List;

public record ExtractSurveyRequest(
        @NotBlank String signature,
        @NotBlank String symbol,
        @NotEmpty List<@NotNull SymbolObject> deposits,
        @NotNull LocalDateTime expiration,
        @NotNull DepositSize size
) {
}
