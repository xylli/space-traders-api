package com.deatr.xylli.speatr.dto.data;

import com.deatr.xylli.speatr.dto.types.FactionTraitType;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.util.List;

@Valid
public record Faction(
        @NotBlank String symbol,
        @NotBlank String name,
        @NotBlank String description,
        @NotBlank String headquarters,
        @NotNull List<FactionTrait> traits
) {

    @Valid
    public record FactionTrait(
            @NotNull FactionTraitType symbol,
            @NotNull String name,
            @NotNull String description
    ) {
    }
}
