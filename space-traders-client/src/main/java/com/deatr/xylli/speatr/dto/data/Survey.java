package com.deatr.xylli.speatr.dto.data;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.time.LocalDateTime;
import java.util.List;

@Valid
public record Survey(
        @NotBlank String signature,
        @NotBlank String symbol,
        @NotNull List<SurveyDeposit> deposits,
        @NotNull LocalDateTime expiration,
        @NotNull DepositSize size
) {
    @Valid
    public record SurveyDeposit(
            @NotNull String symbol
    ) {
    }

}
