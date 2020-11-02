package test.java.com.phonebookservice.util;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import com.phonebookservice.util.StringUtility;

public class TestStringUtility {
    /**
     * test null string.
     */
    @Test
    public void testIsNullString() {
        Assertions.assertTrue(StringUtility.isNullOrEmptyString(null));
    }

    /**
     * test empty string.
     */
    @Test
    public void testIsEmptyString() {
        Assertions.assertTrue(StringUtility.isNullOrEmptyString(""));
    }

    /**
     * test not empty string.
     */
    @Test
    public void testIsNotEmptyList() {
        Assertions.assertFalse(StringUtility.isNullOrEmptyString("test"));
    }
}
