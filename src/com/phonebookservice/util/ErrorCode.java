package com.phonebookservice.util;

/**
 * Error messages.
 *
 * @author Marwa Saleh
 */
public final class ErrorCode {

    /**
     * Don't let anyone instantiate this class.
     */
    private ErrorCode() {
    }

    public static final String ERROR_DATABASE_NOT_FOUND //
            = "ERROR_DATABASE_NOT_FOUND";
    public static final String ERROR_CONTACT_MISSING = "ERROR_CONTACT_MISSING";
    public static final String ERROR_CONTACT_NOT_FOUND //
            = "ERROR_CONTACT_NOT_FOUND";
    public static final String ERROR_CONTACT_LAST_NAME_MISSING //
            = "ERROR_LAST_NAME_MISSING";
    public static final String ERROR_CONTACT_ID_MISSING //
            = "ERROR_CONTACT_ID_MISSING";
}
