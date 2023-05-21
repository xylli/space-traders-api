package com.deatr.xylli.speatr.service;

import com.deatr.xylli.speatr.client.SystemClient;
import com.deatr.xylli.speatr.dto.data.Waypoint;
import com.deatr.xylli.speatr.filters.WaypointStreamFilter;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.List;
import java.util.stream.IntStream;
import java.util.stream.Stream;

import static com.deatr.xylli.speatr.util.ApiConstants.FIRST_PAGE;
import static com.deatr.xylli.speatr.util.ApiConstants.LIST_REQUEST_LIMIT;

@Service
@Slf4j
@RequiredArgsConstructor
public class SystemService {
    private final SystemClient systemClient;


    public List<Waypoint> getResourceWaypoints(String systemSymbol) {
        return WaypointStreamFilter.getResourceWaypoints(
                getAllWaypoints(systemSymbol)
        );
    }

    public List<Waypoint> getAllWaypoints(String systemSymbol) {
        var firstWaypointPage = systemClient.getFirstWaypointPage(systemSymbol);
        int lastPage = firstWaypointPage.meta().getLastPage();

        var remainingWaypoints = IntStream.range(FIRST_PAGE, lastPage)
                .mapToObj(it -> systemClient.getWaypoints(LIST_REQUEST_LIMIT, it, systemSymbol).data())
                .flatMap(Collection::stream);

        return Stream.concat(firstWaypointPage.data().stream(), remainingWaypoints).toList();
    }
}
