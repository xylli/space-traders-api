package com.deatr.xylli.speatr.components;

import com.deatr.xylli.speatr.client.AgentClient;
import com.deatr.xylli.speatr.client.MetaClient;
import com.deatr.xylli.speatr.client.SystemClient;
import com.deatr.xylli.speatr.config.AppProperties;
import com.deatr.xylli.speatr.service.ContractService;
import com.deatr.xylli.speatr.service.FleetService;
import com.deatr.xylli.speatr.service.SystemService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import static com.deatr.xylli.speatr.util.CommonUtils.prettyPrint;

@Component
@Slf4j
@RequiredArgsConstructor
public class StartupListener implements CommandLineRunner {

    private final AppProperties appProperties;
    private final AgentClient agentClient;
    private final SystemClient systemClient;
    private final MetaClient metaClient;
    private final FleetService fleetService;
    private final ContractService contractService;
    private final SystemService systemService;


    @Override
    public void run(String... args) throws Exception {
        var status = metaClient.status();
        if (!status.version().equals(appProperties.spaceTradersApi().registeredVersion())) {
            log.warn("Registered api version does not match current api version");
        }
        log.info("Status Message: {}", status.status());

/*
        var response = registerAgentClient.registerNewAgent(new RegisterNewAgentRequest(
                StartingFaction.COSMIC,
                "XYLLI-2",
                null
        ));
        var token = response.data().token();
        log.info("token {}", token);
*/

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
