package com.phonebookservice.exception;

/**
 * Exception class internal server.
 *
 * @author Marwa Saleh
 */
public class InternalServerException extends HttpServiceException {
    private static final int INTERNAL_STATUS_CODE = 500;
    private static final String INTERNAL_ERROR_MESSAGE = "Error found";
    private static final String INTERNAL_ERROR_CODE = "ERROR_FOUND";

    /**
     * Initialization of internal server exception.
     *
     * @param cause the case of exception.
     */
    public InternalServerException(final Throwable cause) {
        super(INTERNAL_STATUS_CODE, INTERNAL_ERROR_MESSAGE, INTERNAL_ERROR_CODE,
                cause);
    }
}
