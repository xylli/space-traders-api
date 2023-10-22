package com.deatr.xylli.speatr.util;

import org.springframework.http.HttpStatus;
import org.springframework.web.server.ResponseStatusException;

import java.util.function.Supplier;

public final class ValidationUtils {

    private ValidationUtils() {
    }

    public static Supplier<ResponseStatusException> requiredExceptionSupplier() {
        return requiredExceptionSupplier("Required element not found");
    }
    public static Supplier<ResponseStatusException> requiredExceptionSupplier(String message) {
        return () -> new ResponseStatusException(HttpStatus.NOT_FOUND, message);
    }

    public static Supplier<ResponseStatusException> configurationExceptionSupplier(String message) {
        return () -> new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, message);
    }

    public static Supplier<ResponseStatusException> configurationExceptionSupplier(String message, Throwable cause) {
        return () -> new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, message, cause);
    }

}
