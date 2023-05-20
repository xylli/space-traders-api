package com.deatr.xylli.speatr.dto.data;

import com.deatr.xylli.speatr.dto.types.TransactionType;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;

import java.time.LocalDateTime;

public record MarketTransaction(
    @NotNull String waypointSymbol,
    @NotNull String shipSymbol,
    @NotNull String tradeSymbol,
    @NotNull TransactionType type,
    @Positive int units,
    @Positive int pricePerUnit,
    @Positive int totalPrice,
    @NotNull LocalDateTime timestamp
) {
}
