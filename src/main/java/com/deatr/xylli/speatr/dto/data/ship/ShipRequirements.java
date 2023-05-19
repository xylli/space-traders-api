package com.deatr.xylli.speatr.dto.data.ship;


import jakarta.validation.Valid;

@Valid
public record ShipRequirements(
        Integer power,
        Integer crew,
        Integer slots
) {
}
