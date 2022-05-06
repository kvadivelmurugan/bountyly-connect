package com.bountyly.connect;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;

@SpringBootApplication (exclude = SecurityAutoConfiguration.class)
public class BountylyConnectApplication {
	public static void main(String[] args) {
		SpringApplication.run(BountylyConnectApplication.class, args);
	}
}
