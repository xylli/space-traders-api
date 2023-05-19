package com.deatr.xylli.speatr.util;

import org.springframework.http.HttpStatus;
import org.springframework.web.server.ResponseStatusException;

import java.util.Optional;
import java.util.function.Supplier;

public final class ValidationUtils {

    private ValidationUtils() {
    }

    public static Supplier<ResponseStatusException> throwRequiredException() {
        return throwRequiredException("Required element not found");
    }
    public static Supplier<ResponseStatusException> throwRequiredException(String message) {
        return () -> new ResponseStatusException(HttpStatus.NOT_FOUND, message);
    }
}
