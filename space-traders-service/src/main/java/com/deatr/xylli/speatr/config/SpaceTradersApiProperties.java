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

    public Optional<LocalDate> getAccessTokenResetDate() {
        if (accessToken == null) {
            return Optional.empty();
        }
        String[] parts = accessToken.split("\\.");
        if (parts.length > 3) {
            log.error("Unexpected access token format");
            return Optional.empty();
        }
        String dataPart = parts[1];
        try {
            byte[] decodedBytes = Base64.getDecoder().decode(dataPart);
            String decoded = new String(decodedBytes);
            var data = CommonUtils.readValue(decoded, AccessTokenData.class);
            return data.map(it -> LocalDate.parse(it.reset_date()));
        } catch (Exception e) {
            log.error("Could not parse the date from the access token", e);
        }
        return Optional.empty();
    }

    private record AccessTokenData(
            String identifier,
            String version,
            String reset_date,
            long iat,
            String sub
    ) {
    }

    public record RegistrationProperties(
            @NotBlank String name,
            @NotNull StartingFaction faction,
            @Nullable @Email String email
    ) {}
}
