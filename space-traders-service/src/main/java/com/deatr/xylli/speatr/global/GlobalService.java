package com.deatr.xylli.speatr.global;

import com.deatr.speatr.api.GlobalApi;
import com.deatr.speatr.model.GetStatus200Response;
import com.deatr.xylli.speatr.infra.DataService;
import com.deatr.xylli.speatr.infra.ModifyingMethod;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@Slf4j
@DataService
@RequiredArgsConstructor
public class GlobalService {
    private final GlobalApi globalApi;
    private final ApiStatusRepository apiStatusRepository;

    @ModifyingMethod
    public void startupApp() {
        var response = globalApi.getStatus().block();
        if (response == null) {
            log.warn("Could not get status from api");
            return;
        }
        var potentialLastStatus = apiStatusRepository.findFirstByOrderByCreatedAtDesc();
        if (potentialLastStatus.isPresent()) {
            var lastVersion = potentialLastStatus.get().getVersion();
            var currentVersion = response.getVersion();
            if (!lastVersion.equals(currentVersion)) {
                log.warn("Last api version '{}' does not match current api version '{}'", lastVersion, currentVersion);
            }
        }
        log.info("Status Message: {}", response.getStatus());
        createApiStatus(response);
    }


    public void createApiStatus(GetStatus200Response response) {
        var entity = new ApiStatus();
        entity.setVersion(response.getVersion());
        entity.setStatus(response.getStatus());
        entity.setLastResetDate(LocalDate.parse(response.getResetDate()));
        var serverResets = response.getServerResets();
        entity.setServerResetNextDate(LocalDateTime.parse(serverResets.getNext(), DateTimeFormatter.ISO_DATE_TIME));
        entity.setServerResetFrequency(serverResets.getFrequency());

        apiStatusRepository.save(entity);
    }

}
