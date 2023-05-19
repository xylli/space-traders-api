package com.deatr.xylli.speatr.dto.response;

import com.deatr.xylli.speatr.dto.data.Chart;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;

@Valid
public record ChartResponse(
        @NotNull Chart chart,
        @NotNull WaypointResponse waypoint
) {
}
