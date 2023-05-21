package com.deatr.xylli.speatr.client;

import com.deatr.xylli.speatr.dto.DataListWrapper;
import com.deatr.xylli.speatr.dto.DataWrapper;
import com.deatr.xylli.speatr.dto.request.DeliverContractRequest;
import com.deatr.xylli.speatr.dto.response.AcceptedContractResponse;
import com.deatr.xylli.speatr.dto.data.Contract;
import com.deatr.xylli.speatr.dto.response.DeliverContractResponse;
import com.deatr.xylli.speatr.dto.response.FulfilledContractResponse;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Positive;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.service.annotation.GetExchange;
import org.springframework.web.service.annotation.PostExchange;

import static com.deatr.xylli.speatr.util.ApiConstants.FIRST_PAGE;
import static com.deatr.xylli.speatr.util.ApiConstants.LIST_REQUEST_LIMIT;

@Validated
public interface ContractClient {

    default DataListWrapper<Contract> getMyFirstContracts() {
        return getMyContracts(LIST_REQUEST_LIMIT, FIRST_PAGE);
    }

    @GetExchange("/my/contracts")
    DataListWrapper<Contract> getMyContracts(
            @RequestParam @Positive @Max(LIST_REQUEST_LIMIT) int limit,
            @RequestParam @Positive int page
    );

    @GetExchange("/my/contracts/{contractId}")
    DataWrapper<Contract> getContract(
            @PathVariable String contractId
    );
    @PostExchange("/my/contracts/{contractId}/accept")
    DataWrapper<AcceptedContractResponse> acceptContract(
            @PathVariable String contractId
    );

    @PostExchange("/my/contracts/{contractId}/deliver")
    DataWrapper<DeliverContractResponse> deliverContract(
            @PathVariable String contractId,
            @RequestBody DeliverContractRequest body
    );
    @PostExchange("/my/contracts/{contractId}/fulfill")
    DataWrapper<FulfilledContractResponse> fulfillContract(
            @PathVariable String contractId,
            @RequestBody DeliverContractRequest body
    );

}
