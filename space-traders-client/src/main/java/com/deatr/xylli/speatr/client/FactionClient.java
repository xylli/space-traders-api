package com.deatr.xylli.speatr.client;

import com.deatr.xylli.speatr.dto.DataListWrapper;
import com.deatr.xylli.speatr.dto.DataWrapper;
import com.deatr.xylli.speatr.dto.data.Faction;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Positive;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.service.annotation.GetExchange;

@Validated
public interface FactionClient {

    default DataListWrapper<Faction> getFirstFactions() {
        return getFactions(20, 1);
    }

    @GetExchange("/factions")
    DataListWrapper<Faction> getFactions(
            @RequestParam @Positive @Max(20) int limit,
            @RequestParam @Positive int page
    );

    @GetExchange("/factions/{factionSymbol}")
    DataWrapper<Faction> getFaction(
            @PathVariable String factionSymbol
    );


}
