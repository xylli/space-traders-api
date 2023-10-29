package com.deatr.xylli.speatr.security;

import com.deatr.xylli.speatr.util.CommonUtils;
import jakarta.annotation.Nullable;
import lombok.extern.slf4j.Slf4j;

import java.time.LocalDate;
import java.util.Base64;
import java.util.Optional;

@Slf4j
public record CachedAccessToken(
        @Nullable String token,
        LocalDate expiration
) {
    public CachedAccessToken(String token) {
        this(token, getAccessTokenResetDate(token).orElse(LocalDate.MAX));
    }

    public boolean isEmpty() {
        return token == null;
    }

    public static CachedAccessToken empty() {
        return new CachedAccessToken(null, LocalDate.MAX);
    }

    private static Optional<LocalDate> getAccessTokenResetDate(String token) {
        String[] parts = token.split("\\.");
        if (parts.length > 3) {
            log.error("Unexpected access token format");
            return Optional.empty();
        }
        String dataPart = parts[1];
        try {
            byte[] decodedBytes = Base64.getDecoder().decode(dataPart);
            String decoded = new String(decodedBytes);
            var data = CommonUtils.readValue(decoded, AccessTokenData.class);
            return data.map(AccessTokenData::parseResetDate);
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

        private LocalDate parseResetDate() {
            return LocalDate.parse(reset_date);
        }
    }

}
