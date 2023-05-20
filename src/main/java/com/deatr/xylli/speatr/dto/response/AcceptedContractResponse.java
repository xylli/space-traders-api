package com.deatr.xylli.speatr.dto.response;

import com.deatr.xylli.speatr.dto.data.Agent;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;

@Valid
public record AcceptedContractResponse(
    @NotNull Agent agent,
    @NotNull ContractResponse contract
) {

}
