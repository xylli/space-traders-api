package com.deatr.xylli.speatr.exception;

import com.deatr.xylli.speatr.dto.error.ErrorResponse;


public class SpaceTradersApiException extends RuntimeException {

    public SpaceTradersApiException(ErrorResponse errorResponse) {
        super(getFormattedError(errorResponse));
    }

    private static String getFormattedError(ErrorResponse errorResponse) {
        var error = errorResponse.error();
        return "Space traders error:" + "(" + error.code() + ") " + error.message() + " data: " + error.data();
    }
}
