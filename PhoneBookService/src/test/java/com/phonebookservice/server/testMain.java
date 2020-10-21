package test.java.com.phonebookservice.server;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import com.phonebookservice.server.Main;

public class testMain {

	@Test
	public void testMain() {
       assertEquals(Boolean.TRUE, Main.checkValue());
	}
}
