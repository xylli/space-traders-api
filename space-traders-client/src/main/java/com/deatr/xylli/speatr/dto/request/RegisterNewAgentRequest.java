package com.deatr.xylli.speatr.dto.request;

import com.deatr.xylli.speatr.dto.types.StartingFaction;
import com.deatr.xylli.speatr.util.CommonUtils;
import jakarta.annotation.Nullable;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

import java.util.UUID;

@Valid
public record RegisterNewAgentRequest(
        @NotNull StartingFaction faction,
        @NotNull @Size(min = 3, max = MAX_SYMBOL_LENGTH) String symbol,
        @Nullable String email
) {

    public static final int MAX_SYMBOL_LENGTH = 14;

    public static RegisterNewAgentRequest random() {
        var randomName = UUID.randomUUID().toString().substring(0, MAX_SYMBOL_LENGTH - 1);
        var randomFaction = CommonUtils.randomValue(StartingFaction.values());
        return new RegisterNewAgentRequest(randomFaction, randomName, null);
    }
}
