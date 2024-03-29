package com.deatr.xylli.speatr.dto.response;

import com.deatr.xylli.speatr.dto.data.SpeatrAgent;
import com.deatr.xylli.speatr.dto.data.Contract;
import com.deatr.xylli.speatr.dto.data.Faction;
import com.deatr.xylli.speatr.dto.data.ship.Ship;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;

@Valid
public record RegisterNewAgentResponse(
        @NotNull SpeatrAgent agent,
        @NotNull Contract contract,
        @NotNull Faction faction,
        @NotNull Ship ship,
        @NotNull String token
) {
}
