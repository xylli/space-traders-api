package com.deatr.xylli.speatr.dto.data;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.PositiveOrZero;

import java.time.LocalDateTime;

@Valid
public record Cooldown(
    @NotBlank String shipSymbol,
    @PositiveOrZero int totalSeconds,
    @PositiveOrZero int remainingSeconds,
    @NotNull LocalDateTime expiration
) {
}
