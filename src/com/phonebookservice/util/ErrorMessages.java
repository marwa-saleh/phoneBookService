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
    public static final String ERROR_CONTACT_IS_NOT_FOUND //
            = "Contact is not found";
    public static final String ERROR_LAST_NAME_IS_NULL //
            = "Last name cannot be null";
    public static final String ERROR_CONTACT_ID_IS_NULL //
            = "Contact id cannot be null";
    public static final String ERROR_DATABASE_LINK_IS_INVALID //
            = "Database link id is invalid";
    public static final String ERROR_READING_CONTACTS //
            = "Error reading contacts from file";
    public static final String ERROR_WRITING_CONTACTS //
            = "Error wrting contacts in file";
}
