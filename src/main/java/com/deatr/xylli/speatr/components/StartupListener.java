package com.deatr.xylli.speatr.components;

import com.deatr.xylli.speatr.client.AgentClient;
import com.deatr.xylli.speatr.client.SystemClient;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
@Slf4j
@RequiredArgsConstructor
public class StartupListener implements CommandLineRunner {

	private final AgentClient agentClient;
	private final SystemClient systemClient;


    @Override
    public void run(String... args) throws Exception {
		var agentResponse = agentClient.getMyAgent();
        log.info("My Agent: {}", agentResponse.data());

/*        var systems = systemClient.getSystems(20, 1);
        log.info("First systems: {}", systems);*/

        String systemSymbol = "X1-DF55";
        var startingSystem = systemClient.getSystem(systemSymbol);

        var waypointsInSystem = systemClient.getWaypoints(20, 1, systemSymbol);
        log.info("Waypoints: {}", waypointsInSystem);

    }
}
