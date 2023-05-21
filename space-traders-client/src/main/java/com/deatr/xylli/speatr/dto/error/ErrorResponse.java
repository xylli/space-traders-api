package com.deatr.xylli.speatr.dto.error;

import com.fasterxml.jackson.databind.JsonNode;
import jakarta.validation.constraints.NotNull;

public record ErrorResponse(@NotNull ErrorMessage error) {

    public record ErrorMessage(
            @NotNull String message,
            int code,
            JsonNode data
    ) {

    }
}
