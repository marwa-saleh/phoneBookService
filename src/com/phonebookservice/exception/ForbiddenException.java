package com.phonebookservice.exception;

public class ForbiddenException extends HttpServiceException {
    private static final int FORBIDDEN_STATUS_CODE = 403;

    /**
     * Initialization of bad request exception.
     *
     * @param errorMessage the error message.
     * @param errorCode    the error code.
     */
    public ForbiddenException(final String errorMessage,
            final String errorCode) {
        super(FORBIDDEN_STATUS_CODE, errorMessage, errorCode);
    }
}
