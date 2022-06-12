package com.example.bank;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.config.server.EnableConfigServer;
import org.springframework.cloud.openfeign.EnableFeignClients;



@SpringBootApplication
@EnableConfigServer
@EnableFeignClients
public class BankManagementSystemApplication {
	private static final Logger logger = LoggerFactory.getLogger(BankManagementSystemApplication.class);
	public static void main(String[] args) {
		logger.info("this is bank management spring boot application ");
		SpringApplication.run(BankManagementSystemApplication.class, args);
	}

}
