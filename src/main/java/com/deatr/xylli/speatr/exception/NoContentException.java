package com.deatr.xylli.speatr.exception;

/**
 * 204 no content response will return content type html, which will cause issues
 */
public class NoContentException extends RuntimeException {

    public NoContentException() {
        super("No content response from api");
    }
}
