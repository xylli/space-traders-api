package com.deatr.xylli.speatr.dto;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;

@Valid
public record SymbolObject(@NotBlank String symbol) {
}
