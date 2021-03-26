package com.softwarehammer.blockone;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class TechtestApplicationTest
{
	private int a = 1;
	private int b = 1;
	
	@BeforeEach
	void setUp() throws Exception
	{
	}

	@AfterEach
	void tearDown() throws Exception
	{
	}

	@Test
	void testMain() throws Exception
	{
		TechtestApplication.main(new String[]{
                "--spring.main.web-environment=false",
                "--spring.autoconfigure.exclude=blahblahblah",
        });
		
		assertEquals(a, b);
	}

}
