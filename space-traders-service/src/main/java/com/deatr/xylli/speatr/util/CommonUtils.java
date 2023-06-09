package com.deatr.xylli.speatr.util;

import com.deatr.xylli.speatr.filters.WaypointStreamFilter;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.slf4j.Slf4j;

import java.util.Arrays;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Stream;

@Slf4j
public final class CommonUtils {
    private static final ObjectMapper MAPPER = new ObjectMapper();

    private CommonUtils() {
    }

    /**
     * Pretty print the object as json
     */
    public static <T> String prettyPrint(T object) {
        try {
            return MAPPER.writerWithDefaultPrettyPrinter().writeValueAsString(object);
        } catch (JsonProcessingException e) {
            log.error("Could not write object", e);
        }
        return "null";
    }

    public static <T, F> Predicate<T> oneOf(F[] filterBy, Function<F, Predicate<T>> predicateMapper) {
        return oneOf(Arrays.stream(filterBy).map(predicateMapper));
    }
    public static <T> Predicate<T> oneOf(Stream<Predicate<T>> predicates) {
        return predicates.reduce(it -> false, Predicate::or);
    }
}
