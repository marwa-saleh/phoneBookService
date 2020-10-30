package com.phonebookservice.util;

public abstract class StringUtility {

    /**
     * Checks whether a string is null or empty.
     *
     * @param s the string
     * @return true if the string is not null or empty, else false
     */
    public static boolean isNullOrEmptyString(final String s) {
        return (s == null || s.isEmpty());
    }

}
