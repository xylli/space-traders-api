package com.deatr.xylli.speatr.dto.request;

import com.deatr.xylli.speatr.dto.types.StartingFaction;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

@Valid
public record RegisterNewAgentRequest(
        @NotNull StartingFaction faction,
        @NotNull @Size(min = 3, max = 14) String symbol,
        String email
) {
}
