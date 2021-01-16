package com.phonebookservice.util;

import java.util.Map;

public final class MapUtility {
    /**
     * Don't let anyone instantiate this class.
     */
    private MapUtility() {
    }

    /**
     * Checks whether the given map is null or empty.
     *
     * @param map the map
     * @return true if the map is null or empty, false otherwise
     */
    public static boolean isNullOrEmptyMap(
            final Map<? extends Object, ? extends Object> map) {
        return map == null || map.isEmpty();
    }

    /**
     * Checks whether the given map is not null or empty.
     *
     * @param map the map
     * @return true if the map is not null or empty, false otherwise
     */
    public static boolean isNotNullOrEmptyMap(
            final Map<? extends Object, ? extends Object> map) {
        return !isNullOrEmptyMap(map);
    }
}
