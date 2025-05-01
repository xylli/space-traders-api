package com.deatr.xylli.speatr.components;

import com.deatr.speatr.model.FactionSymbol;
import com.deatr.xylli.speatr.agent.AgentCreationRequest;
import com.deatr.xylli.speatr.agent.AgentService;
import com.deatr.xylli.speatr.config.SpaceTradersApiProperties;
import com.deatr.xylli.speatr.service.FleetService;
import com.deatr.xylli.speatr.service.SystemService;
import com.deatr.xylli.speatr.status.StatusService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.stereotype.Component;

import java.util.Optional;
import java.util.UUID;

import static com.deatr.xylli.speatr.util.CommonUtils.prettyPrint;

@ConditionalOnProperty("app.startup.enabled")
@Component
@Slf4j
@RequiredArgsConstructor
public class StartupListener implements CommandLineRunner {

    private final SpaceTradersApiProperties spaceTradersApiProperties;
    private final FleetService fleetService;
    private final SystemService systemService;
    private final StatusService statusService;
    private final AgentService agentService;


    @Override
    public void run(String... args) {
        statusService.updateAppStatus();

        var email = Optional.ofNullable(spaceTradersApiProperties.registration()).map(SpaceTradersApiProperties.RegistrationProperties::email).orElse(null);
        var symbol = UUID.randomUUID().toString().substring(0, 10);
        agentService.createAgent(new AgentCreationRequest(FactionSymbol.QUANTUM, symbol, email));


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
