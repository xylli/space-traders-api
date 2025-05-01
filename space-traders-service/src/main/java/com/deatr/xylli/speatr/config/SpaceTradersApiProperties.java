package com.deatr.xylli.speatr.config;

import com.deatr.xylli.speatr.dto.types.StartingFaction;
import jakarta.annotation.Nullable;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public record SpaceTradersApiProperties(
        String baseUrl,
        @Nullable String accountToken,
        @NotBlank String registeredVersion,
        @Nullable RegistrationProperties registration
) {

    public String accountToken() {
        return accountToken == null || accountToken.isBlank() ? null : accountToken;
    }

    public record RegistrationProperties(
            @NotBlank String name,
            @NotNull StartingFaction faction,
            @Nullable @Email String email
    ) {}
}
