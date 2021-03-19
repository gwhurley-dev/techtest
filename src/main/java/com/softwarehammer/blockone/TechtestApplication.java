package com.softwarehammer.blockone;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


@SpringBootApplication
public class TechtestApplication implements CommandLineRunner
{
	Logger logger = LoggerFactory.getLogger(TechtestApplication.class);

    public TechtestApplication()
    {
    }
    
    @Override
    public void run(String... args) throws Exception
    {
    	logger.info("TechtestApplication has started.");
    }
    
	public static void main(String[] args) throws Exception
	{
		SpringApplication.run(TechtestApplication.class, args);
	}


}
