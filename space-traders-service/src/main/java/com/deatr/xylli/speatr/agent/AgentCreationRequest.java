package com.deatr.xylli.speatr.agent;

import com.deatr.speatr.model.FactionSymbol;
import com.deatr.speatr.model.RegisterRequest;
import jakarta.annotation.Nullable;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record AgentCreationRequest(
        @NotNull FactionSymbol faction,
        @NotBlank String symbol,
        @Nullable String email
) {

    public RegisterRequest toRegisterRequest() {
        return new RegisterRequest()
                .faction(faction)
                .symbol(symbol)
                .email(email);
    }
}
