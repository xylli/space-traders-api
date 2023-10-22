package com.deatr.xylli.speatr.config;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.validation.annotation.Validated;

@ConfigurationProperties("app")
@Validated
public record AppProperties(@Valid @NotNull SpaceTradersApiProperties spaceTradersApi) {

}
