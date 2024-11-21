package com.example.test;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class TestApplication {

	public static void main(String[] args) {
		SpringApplication.run(TestApplication.class, args);
		System.out.println("==============================================");
		System.out.println("H2 Console is available at: http://localhost:8087/h2-console");
		System.out.println("Username: test");
		System.out.println("Password: test");
		System.out.println("==============================================");
		System.out.flush();
	}
}
