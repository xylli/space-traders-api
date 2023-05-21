package com.deatr.xylli.speatr.service;

import com.deatr.xylli.speatr.client.ContractClient;
import com.deatr.xylli.speatr.dto.DataListWrapper;
import com.deatr.xylli.speatr.dto.data.Contract;
import com.deatr.xylli.speatr.exception.SpaceTradersApiException;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@Slf4j
@RequiredArgsConstructor
public class ContractService {

    private final ContractClient contractClient;

    public DataListWrapper<Contract> getMyFirstContracts() {
        return contractClient.getMyFirstContracts();
    }

    public void acceptContract(String contractId) {
        try {
            var response = contractClient.acceptContract(contractId);
            log.info("Accepted contract: {}", response);
        } catch (SpaceTradersApiException responseException) {
            log.error("Accepting the contract '" + contractId + "' failed with", responseException);
        }
    }
}
