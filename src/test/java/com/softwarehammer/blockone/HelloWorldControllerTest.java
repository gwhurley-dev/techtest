package com.softwarehammer.blockone;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class HelloWorldControllerTest
{
	private HelloWorldController hc;

	@BeforeEach
	void setUp() throws Exception
	{
		hc = new HelloWorldController();
	}

	@AfterEach
	void tearDown() throws Exception
	{
	}

	@Test
	void testSayHello()
	{
		assertEquals("Hello World....", hc.sayHello());
	}

}
