package com.gwhurley.techtest;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class TechtestApplication {

	public static void main(String[] args) {
		SpringApplication.run(TechtestApplication.class, args);
		//SpringApplication.run(HelloWorldController.class, args);
		System.out.println("Test1.");
	}

}
