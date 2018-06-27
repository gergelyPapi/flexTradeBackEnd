package com.codecool.flexTradeBackEnd;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.SecurityAutoConfiguration;

@SpringBootApplication(exclude = {SecurityAutoConfiguration.class })
public class FlexTradeBackEndApplication {

	public static void main(String[] args) {
		SpringApplication.run(FlexTradeBackEndApplication.class, args);
	}
}
