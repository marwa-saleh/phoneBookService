package com.phonebookservice.exception;

/**
 * Exception class for bad request.
 *
 * @author Marwa Saleh
 */
public class NotFoundException extends HttpServiceException {
    private static final int NOT_FOUND_STATUS_CODE = 404;

    /**
     * Initialization of bad request exception.
     *
     * @param errorMessage the error message.
     * @param errorCode    the error code.
     */
    public NotFoundException(final String errorMessage,
            final String errorCode) {
        super(NOT_FOUND_STATUS_CODE, errorMessage, errorCode);
    }
}
