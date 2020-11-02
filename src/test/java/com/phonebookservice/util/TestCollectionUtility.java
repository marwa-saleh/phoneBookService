package test.java.com.phonebookservice.util;

import java.util.ArrayList;
import java.util.Arrays;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import com.phonebookservice.util.CollectionUtility;

public class TestCollectionUtility {
    /**
     * test null list.
     */
    @Test
    public void testIsNullList() {
        Assertions.assertTrue(CollectionUtility.isNullOrEmptyList(null));
    }

    /**
     * test empty list.
     */
    @Test
    public void testIsEmptyList() {
        Assertions.assertTrue(
                CollectionUtility.isNullOrEmptyList(new ArrayList<String>()));
    }

    /**
     * test not empty list.
     */
    @Test
    public void testIsNotEmptyList() {
        Assertions.assertFalse(
                CollectionUtility.isNullOrEmptyList(Arrays.asList("test")));
    }
}
