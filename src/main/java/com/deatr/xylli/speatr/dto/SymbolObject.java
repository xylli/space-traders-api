package com.deatr.xylli.speatr.dto;

import jakarta.validation.constraints.NotBlank;
import org.springframework.validation.annotation.Validated;

@Validated
public record SymbolObject(@NotBlank String symbol) {
}
