package com.deatr.xylli.speatr.dto.data;

import com.deatr.xylli.speatr.dto.types.MarketSupplyType;
import com.deatr.xylli.speatr.dto.types.TradeSymbol;
import com.deatr.xylli.speatr.dto.types.TransactionType;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;

import java.time.LocalDateTime;
import java.util.List;

@Valid
public record Market(
        @NotBlank
        String symbol,
        @NotNull
        List<TradeGood> imports,
        @NotNull
        List<TradeGood> exports,
        @NotNull
        List<TradeGood> exchange,
        @NotNull
        List<Transaction> transactions,
        @NotNull
        List<MarketTradeGood> tradeGoods
) {

    @Valid
    public record TradeGood(
            @NotNull
            TradeSymbol symbol,
            @NotBlank
            String name,
            String description
    ) {
    }

    @Valid
    public record Transaction(
            @NotBlank
            String waypointSymbol,
            @NotBlank
            String shipSymbol,
            @NotBlank
            String tradeSymbol,
            @NotNull
            TransactionType type,
            @Positive
            int units,
            @Positive
            int pricePerUnit,
            @Positive
            int totalPrice,
            @NotNull
            LocalDateTime timestamp
    ) {
    }

    @Valid
    public record MarketTradeGood(
            @NotBlank String symbol,
            @Positive int tradeVolume,
            @NotNull MarketSupplyType supply,
            @Positive int purchasePrice,
            @Positive int sellPrice
    ) {
    }
}
