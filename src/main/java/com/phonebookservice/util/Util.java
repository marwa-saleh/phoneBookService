package main.java.com.phonebookservice.util;

import java.util.Collection;

public final class Util {

    private Util() {

    }

    /**
     * Checks whether a string is null or empty.
     *
     * @param s the string
     * @return true if the string is not null or empty, else false
     */
    public static boolean isNullOrEmptyString(final String s) {
        return (s == null || s.isEmpty());
    }

    /**
     * Checks whether a list is null or empty.
     *
     * @param list the list
     * @return true if the list is null or empty, else false
     */
    public static boolean isNullOrEmptyList(final Collection list) {
        return (list == null || list.isEmpty());
    }
}
