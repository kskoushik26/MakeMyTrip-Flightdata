package com.makemytrip.data;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;


@EnableDiscoveryClient
@SpringBootApplication
public class MakeMyFlightDataApplication {

	public static void main(String[] args) {
		SpringApplication.run(MakeMyFlightDataApplication.class, args);
	}

}

