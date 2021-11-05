package com.sportstelling;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;

@SpringBootApplication
public class SportsTellingApplication extends SpringBootServletInitializer{

	public static void main(String[] args) {
		SpringApplication.run(SportsTellingApplication.class, args);
	}

}
