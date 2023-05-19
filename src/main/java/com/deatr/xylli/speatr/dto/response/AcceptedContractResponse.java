package com.deatr.xylli.speatr.dto.response;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;

@Valid
public record AcceptedContractResponse(
    @NotNull AgentResponse agent,
    @NotNull ContractResponse contract
) {

}
