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
    public static Supplier<ResponseStatusException> requiredExceptionSupplier(String message, String... args) {
        return () -> notFoundException(message, args);
    }

    public static ResponseStatusException internalServerErrorException(String message, String... args) {
        return responseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, message, args);
    }

    public static ResponseStatusException badRequestException(String message, String... args) {
        return responseStatusException(HttpStatus.BAD_REQUEST, message, args);
    }

    public static ResponseStatusException notFoundException(String message, String... args) {
        return responseStatusException(HttpStatus.NOT_FOUND, message, args);
    }

    private static ResponseStatusException responseStatusException(HttpStatus status, String message, Object[] args) {
        return new ResponseStatusException(status, String.format(message, args));
    }

}
