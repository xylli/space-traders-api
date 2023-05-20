package com.deatr.xylli.speatr.dto.request;

import com.deatr.xylli.speatr.dto.types.FlightMode;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;

@Valid
public record UpdateNavRequest(
        @NotBlank FlightMode flightMode
) {

}
