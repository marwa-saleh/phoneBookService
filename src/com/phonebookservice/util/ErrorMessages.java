package com.phonebookservice.util;

/**
 * Error messages.
 *
 * @author Marwa Saleh
 */
public final class ErrorMessages {

    /**
     * Don't let anyone instantiate this class.
     */
    private ErrorMessages() {
    }

    public static final String ERROR_DATABASE_NOT_FOUND //
            = "Database object cannot be null";
    public static final String ERROR_CONTACT_IS_NULL = "contact cannot be null";
    public static final String ERROR_LAST_NAME_IS_NULL //
            = "last name cannot be null";

}
