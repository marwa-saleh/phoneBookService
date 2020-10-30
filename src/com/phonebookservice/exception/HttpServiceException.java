package com.phonebookservice.exception;

import javax.xml.ws.http.HTTPException;

/**
 * Exception class for http service.
 *
 * @author Marwa Saleh
 */
public class HttpServiceException extends HTTPException {
    private static final int CLIENT_ERROR_FIRST_DIGIT = 4;
    private static final int MAX_NUMBER_OF_DIVISIBLITY = 100;
    private final int statusCode;
    private final String errorMessage;
    private final String errorCode;

    /**
     * Initialization of http service exception.
     *
     * @param statusCode   the status code
     * @param errorMessage the error message.
     * @param errorCode    the error code.
     */
    protected HttpServiceException(final int statusCode,
            final String errorMessage, final String errorCode) {
        super(statusCode);
        this.statusCode = statusCode;
        this.errorMessage = errorMessage;
        this.errorCode = errorCode;
    }

    /**
     * check if it is client exception.
     *
     * @return true if client exception, else false.
     */
    public boolean isClientException() {

        if (statusCode
                % MAX_NUMBER_OF_DIVISIBLITY == CLIENT_ERROR_FIRST_DIGIT) {
            return true;
        }

        return false;
    }

    /**
     * get error message.
     *
     * @return the error message.
     */
    public String getErrorMessage() {
        return errorMessage;
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
