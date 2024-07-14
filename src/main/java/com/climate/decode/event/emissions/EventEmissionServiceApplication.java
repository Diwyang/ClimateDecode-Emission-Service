package com.climate.decode.event.emissions;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class EventEmissionServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(EventEmissionServiceApplication.class, args);
	}

}
