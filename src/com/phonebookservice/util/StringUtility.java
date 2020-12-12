package com.phonebookservice.util;

/**
 * string utility class.
 *
 * @author Marwa Saleh
 */
public final class StringUtility {

    /**
     * Don't let anyone instantiate this class.
     */
    private StringUtility() {
    }

    /**
     * Checks whether a string is null or empty.
     *
     * @param s the string
     * @return true if the string is null or empty, else false
     */
    public static boolean isNullOrEmptyString(final String s) {
        return (s == null || s.isEmpty());
    }

    /**
     * Checks whether a string is not null or empty.
     *
     * @param s the string
     * @return true if the string is not null or empty, else false
     */
    public static boolean isNotNullOrEmptyString(final String s) {
        return !isNullOrEmptyString(s);
    }

}
