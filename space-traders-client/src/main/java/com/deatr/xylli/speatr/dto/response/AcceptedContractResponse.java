package com.deatr.xylli.speatr.dto.response;

import com.deatr.xylli.speatr.dto.data.SpeatrAgent;
import com.deatr.xylli.speatr.dto.data.Contract;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;

@Valid
public record AcceptedContractResponse(
    @NotNull SpeatrAgent agent,
    @NotNull Contract contract
) {

}
