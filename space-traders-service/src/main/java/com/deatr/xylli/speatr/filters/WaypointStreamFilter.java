package com.deatr.xylli.speatr.filters;

import com.deatr.xylli.speatr.dto.data.Waypoint;
import com.deatr.xylli.speatr.dto.types.WaypointTrait;
import com.deatr.xylli.speatr.dto.types.WaypointType;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;

import java.util.Collection;
import java.util.List;
import java.util.function.Predicate;

import static com.deatr.xylli.speatr.util.CommonUtils.oneOf;

@RequiredArgsConstructor(access = AccessLevel.PRIVATE)
public class WaypointStreamFilter {
    private final Collection<Waypoint> waypoints;


    private List<Waypoint> filter(Predicate<Waypoint> filter) {
        return waypoints.stream().filter(filter).toList();
    }

    private static Predicate<Waypoint> hasOneOf(WaypointTrait[] traits) {
        return oneOf(traits, WaypointStreamFilter::hasTrait);
    }

    private static Predicate<Waypoint> hasOneOf(WaypointType[] types) {
        return oneOf(types, WaypointStreamFilter::isType);
    }

    private static Predicate<Waypoint> hasTrait(WaypointTrait trait) {
        return waypoint -> waypoint.hasTrait(trait);
    }

    private static Predicate<Waypoint> isType(WaypointType type) {
        return waypoint -> waypoint.isType(type);
    }

    public static List<Waypoint> filtered(Collection<Waypoint> waypoints, WaypointTrait... traits) {
        return new WaypointStreamFilter(waypoints).filter(hasOneOf(traits));
    }

    public static List<Waypoint> filtered(Collection<Waypoint> waypoints, WaypointType... types) {
        return new WaypointStreamFilter(waypoints).filter(hasOneOf(types));
    }

    public static List<Waypoint> getResourceWaypoints(Collection<Waypoint> waypoints) {
        return filtered(
                waypoints,
                WaypointTrait.MINERAL_DEPOSITS,
                WaypointTrait.COMMON_METAL_DEPOSITS,
                WaypointTrait.PRECIOUS_METAL_DEPOSITS,
                WaypointTrait.RARE_METAL_DEPOSITS
        );
    }
}
