package com.deatr.xylli.speatr.dto.response;

import com.deatr.xylli.speatr.dto.types.ContractType;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.time.LocalDateTime;
import java.util.List;

@Valid
public record ContractResponse(
        @NotBlank String id,
        @NotBlank String factionSymbol,
        @NotNull ContractType type,
        @NotNull ContractTerms terms,
        boolean accepted,
        boolean fulfilled,
        @NotNull LocalDateTime expiration
) {

    @Valid
    public record ContractTerms(
            @NotNull LocalDateTime deadline,
            @NotNull ContractPayment payment,
            @NotNull List<ContractDeliverGood> deliver
    ) {
    }

    @Valid
    public record ContractPayment(
            int onAccepted,
            int onFulfilled
    ) {
    }

    @Valid
    public record ContractDeliverGood(
            @NotBlank String tradeSymbol,
            @NotBlank String destinationSymbol,
            int unitsRequired,
            int unitsFulfilled

    ) {}
}
