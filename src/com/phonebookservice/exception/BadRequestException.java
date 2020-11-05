package com.phonebookservice.exception;

/**
 * Exception class for bad request.
 *
 * @author Marwa Saleh
 */
public class BadRequestException extends HttpServiceException {
    private static final int BAD_REQUEST_STATUS_CODE = 400;

    /**
     * Initialization of bad request exception.
     *
     * @param errorMessage the error message.
     * @param errorCode    the error code.
     */
    public BadRequestException(final String errorMessage,
            final String errorCode) {
        super(BAD_REQUEST_STATUS_CODE, errorMessage, errorCode);
    }
}
