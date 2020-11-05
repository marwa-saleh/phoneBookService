package com.phonebookservice.util;

import java.util.Collection;

/**
 * collection utility class.
 *
 * @author Marwa Saleh
 */
public final class CollectionUtility {

    /**
     * Don't let anyone instantiate this class.
     */
    private CollectionUtility() {
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
