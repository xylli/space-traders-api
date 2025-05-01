package com.deatr.xylli.speatr.components;

import com.deatr.speatr.api.GlobalApi;
import com.deatr.xylli.speatr.config.SpaceTradersApiProperties;
import com.deatr.xylli.speatr.service.FleetService;
import com.deatr.xylli.speatr.service.SystemService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.stereotype.Component;

import static com.deatr.xylli.speatr.util.CommonUtils.prettyPrint;

@ConditionalOnProperty("app.startup.enabled")
@Component
@Slf4j
@RequiredArgsConstructor
public class StartupListener implements CommandLineRunner {

    private final SpaceTradersApiProperties spaceTradersApiProperties;
    private final FleetService fleetService;
    private final SystemService systemService;
    private final GlobalApi globalApi;


    @Override
    public void run(String... args) {
        var response = globalApi.getStatus().block();
        if (response == null) {
            log.warn("Could not get status from api");
            return;
        }
        if (!response.getVersion().equals(spaceTradersApiProperties.registeredVersion())) {
            log.warn("Registered api version '{}' does not match current api version '{}'", spaceTradersApiProperties.registeredVersion(), response.getVersion());
        }
        log.info("Status Message: {}", response.getStatus());

/*
		var agentResponse = agentClient.getMyAgent();
        log.info("My Agent: {}", agentResponse.data());
*/


        var myShip = fleetService.getFirstShip();
        String firstShipSymbol = myShip.symbol();
        log.info("My ship {}", firstShipSymbol);
/*
        var firstContract = contractService.getMyFirstContracts().requireFirst();
        log.info("My contract {}", firstContract);

        contractService.acceptContract(firstContract.id());
*/

        var waypoints = systemService.getResourceWaypoints(myShip.nav().systemSymbol());

        log.info("waypoints {}", prettyPrint(waypoints));

        var firstWaypoint = waypoints.stream().findFirst();
        firstWaypoint.ifPresent(waypoint -> fleetService.navigateTo(myShip, waypoint));

/*
        var cooldown = fleetClient.getCooldown(firstShipSymbol);
        log.info("Ship cooldown {}", cooldown);
*/

/*        var systems = systemClient.getSystems(20, 1);
        log.info("First systems: {}", systems);

        String systemSymbol = "X1-ZA40";
        var startingSystem = systemClient.getSystem(systemSymbol);

        var waypointsInSystem = systemClient.getWaypoints(20, 1, systemSymbol);
        log.info("Waypoints: {}", waypointsInSystem);*/

    }
}
