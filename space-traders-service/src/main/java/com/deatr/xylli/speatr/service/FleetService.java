package com.deatr.xylli.speatr.service;

import com.deatr.xylli.speatr.client.FleetClient;
import com.deatr.xylli.speatr.dto.data.Waypoint;
import com.deatr.xylli.speatr.dto.data.ship.Ship;
import com.deatr.xylli.speatr.dto.data.ship.ShipNav;
import com.deatr.xylli.speatr.dto.request.NavigateRequest;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Slf4j
@Service
public class FleetService {
    private final FleetClient fleetClient;


    public Ship getFirstShip() {
        return fleetClient.getMyFirstShips().requireFirst();
    }

    public ShipNav navigateTo(Ship ship, Waypoint waypoint) {
        ShipNav nav;
        if (ship.nav().waypointSymbol().equals(waypoint.symbol())) {
            if (ship.isMoving()) {
                log.info("Ship is navigating to the specified waypoint");
            } else if (ship.isOrbiting()) {
                log.info("Ship is orbiting the specified waypoint");
            } else {
                log.info("Ship is docked at the specified waypoint");
            }
            nav = ship.nav();
        } else {
            String shipSymbol = ship.symbol();
            if (ship.isDocked()) {
                fleetClient.orbit(shipSymbol);
            }
            log.info("Navigating ship {} to waypoint {}", shipSymbol, waypoint.symbol());
            var response = fleetClient.navigate(shipSymbol, new NavigateRequest(waypoint.symbol()));
            nav = response.data().nav();
        }
        return nav;
    }
}
