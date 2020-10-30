package com.phonebookservice.exception;

/**
 * Exception class internal server.
 *
 * @author Marwa Saleh
 */
public class InternetServerException extends HttpServiceException {
    private static final int INTERNAL_STATUS_CODE = 500;

    /**
     * Initialization of internal server exception.
     *
     * @param errorMessage the error message.
     * @param errorCode    the error code.
     */
    public InternetServerException(final String errorMessage,
            final String errorCode) {
        super(INTERNAL_STATUS_CODE, errorMessage, errorMessage);
    }
}
