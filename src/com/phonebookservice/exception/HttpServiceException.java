package com.phonebookservice.exception;

/**
 * Exception class for http service.
 *
 * @author Marwa Saleh
 */
public class HttpServiceException extends RuntimeException {
    private static final int CLIENT_ERROR_FIRST_DIGIT = 4;
    private static final int MAX_NUMBER_OF_DIVISIBLITY = 100;
    private final int statusCode;
    private final String errorCode;

    /**
     * Initialization of http service exception.
     *
     * @param statusCode   the status code.
     * @param errorMessage the error message.
     * @param errorCode    the error code.
     * @param cause        the cause.
     */
    protected HttpServiceException(final int statusCode,
            final String errorMessage, final String errorCode,
            final Throwable cause) {
        super(errorMessage, cause);
        this.statusCode = statusCode;
        this.errorCode = errorCode;
    }

    /**
     * Initialization of http service exception.
     *
     * @param statusCode   the status code.
     * @param errorMessage the error message.
     * @param errorCode    the error code.
     */
    protected HttpServiceException(final int statusCode,
            final String errorMessage, final String errorCode) {
        super(errorMessage);
        this.statusCode = statusCode;
        this.errorCode = errorCode;
    }

    /**
     * check if it is client exception.
     *
     * @return true if client exception, else false.
     */
    public boolean isClientException() {

        return statusCode
                / MAX_NUMBER_OF_DIVISIBLITY == CLIENT_ERROR_FIRST_DIGIT;
    }

    /**
     * get status code.
     *
     * @return the status code.
     */
    public int getStatusCode() {
        return statusCode;
    }

    /**
     * get error code.
     *
     * @return the error code.
     */
    public String getErrorCode() {
        return errorCode;
    }

}
