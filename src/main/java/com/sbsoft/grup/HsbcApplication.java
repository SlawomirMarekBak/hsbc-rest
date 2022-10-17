package com.sbsoft.grup;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages = "com.sbsoft.grup")
@EnableAutoConfiguration
public class HsbcApplication {

	public static void main(String[] args) {
		SpringApplication.run(HsbcApplication.class, args);
	}

}
