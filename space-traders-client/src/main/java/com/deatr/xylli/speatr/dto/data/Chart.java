package com.deatr.xylli.speatr.dto.data;

import jakarta.validation.Valid;

@Valid
public record Chart(
        String waypointSymbol,
        String submittedBy,
        String submittedOn //date-time
) {
}
