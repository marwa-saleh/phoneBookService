package test.java.com.phonebookservice.server;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import main.java.com.phonebookservice.server.Main;

public class TestMain {

	/**
	 * test method checks for value.
	 */
	@Test
	public void testMain() {
		assertEquals(Boolean.TRUE, Main.checkValue());
	}
}
