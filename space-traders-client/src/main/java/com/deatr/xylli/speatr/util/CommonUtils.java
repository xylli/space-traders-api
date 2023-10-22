package com.deatr.xylli.speatr.util;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.slf4j.Slf4j;

import java.util.Arrays;
import java.util.Optional;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Stream;

@Slf4j
public final class CommonUtils {
    private static final ObjectMapper MAPPER = new ObjectMapper();

    static {
        MAPPER.findAndRegisterModules();
    }

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

    /**
     * Try creating an object instance from the string json value
     */
    public static <T> Optional<T> readValue(String jsonValue, Class<T> clazz) {
        try {
            return Optional.ofNullable(MAPPER.readValue(jsonValue, clazz));
        } catch (JsonProcessingException e) {
            log.error("Could not write object", e);
        }
        return Optional.empty();
    }

    public static <T, F> Predicate<T> oneOf(F[] filterBy, Function<F, Predicate<T>> predicateMapper) {
        return oneOf(Arrays.stream(filterBy).map(predicateMapper));
    }
    public static <T> Predicate<T> oneOf(Stream<Predicate<T>> predicates) {
        return predicates.reduce(it -> false, Predicate::or);
    }
}
