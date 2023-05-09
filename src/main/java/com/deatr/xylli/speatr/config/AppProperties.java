package com.deatr.xylli.speatr.config;

import jakarta.validation.constraints.NotBlank;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.validation.annotation.Validated;

@ConfigurationProperties("app")
@Validated
public record AppProperties(SpaceTradersApi spaceTradersApi) {

    @Validated
    public record SpaceTradersApi(
            String baseUrl,
            @NotBlank
            String accessToken
    ){
    }
}
