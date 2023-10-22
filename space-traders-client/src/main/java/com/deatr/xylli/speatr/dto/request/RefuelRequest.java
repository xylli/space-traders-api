package com.deatr.xylli.speatr.dto.request;

import jakarta.annotation.Nullable;
import jakarta.validation.constraints.Positive;

public record RefuelRequest(@Positive @Nullable Integer units) {
}
