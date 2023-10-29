package com.deatr.xylli.speatr.config;

import com.deatr.xylli.speatr.dto.types.StartingFaction;
import com.deatr.xylli.speatr.util.CommonUtils;
import jakarta.annotation.Nullable;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.extern.slf4j.Slf4j;

import java.time.LocalDate;
import java.util.Base64;
import java.util.Optional;

@Slf4j
public record SpaceTradersApiProperties(
        String baseUrl,
        @Nullable String accessToken,
        @NotBlank String registeredVersion,
        @Nullable RegistrationProperties registration
) {

    public String accessToken() {
        return accessToken == null || accessToken.isBlank() ? null : accessToken;
    }

    public record RegistrationProperties(
            @NotBlank String name,
            @NotNull StartingFaction faction,
            @Nullable @Email String email
    ) {}
}
