package test.java.com.phonebookservice.server;

import org.junit.Assert;
import org.junit.jupiter.api.Test;

import main.java.com.phonebookservice.server.Main;

public class TestMain {

    /**
     * test method checks for value.
     */
    @Test
    public void testMain() {
        Assert.assertEquals(Boolean.TRUE, Main.checkValue());
    }
}
