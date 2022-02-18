package com.screcruiting.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@EnableAutoConfiguration
@ComponentScan(basePackages="com.screcruiting")
@SpringBootApplication
public class SomeconpanyrecrutingApplication {

	public static void main(String[] args) {
		SpringApplication.run(SomeconpanyrecrutingApplication.class, args);
	}

}
