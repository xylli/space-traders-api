package com.deatr.xylli.speatr.dto.data.ship;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;

import java.time.LocalDateTime;

@Valid
public record ShipyardTransaction(
        @NotBlank String waypointSymbol,
        @NotBlank String shipSymbol,
        @Positive int price,
        @NotBlank String agentSymbol,
        @NotNull LocalDateTime timestamp
) {
}
