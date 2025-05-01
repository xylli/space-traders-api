package com.deatr.xylli.speatr.config;

import com.deatr.speatr.model.FactionSymbol;
import jakarta.annotation.Nullable;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.validation.annotation.Validated;

@Slf4j
@Validated
@ConfigurationProperties("app.space-traders-api")
public record SpaceTradersApiProperties(
        String baseUrl,
        @NotBlank String accountToken,
        @Nullable RegistrationProperties registration
) {

    public String accountToken() {
        return accountToken == null || accountToken.isBlank() ? null : accountToken;
    }

    public record RegistrationProperties(
            @NotBlank String name,
            @NotNull FactionSymbol faction,
            @Nullable @Email String email
    ) {}
}
