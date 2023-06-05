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
            nav = ship.nav();
            log.info("Ship already navigated to the specified waypoint");
        } else {
            var response = fleetClient.navigate(ship.symbol(), new NavigateRequest(waypoint.symbol()));
            nav = response.data().nav();
            log.info("Navigating ship {} to waypoint {}", ship.symbol(), waypoint.symbol());
        }
        return nav;
    }
}
