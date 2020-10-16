package com.arquitetura.configsservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.config.server.EnableConfigServer;

@SpringBootApplication
@EnableConfigServer
public class ConfigsServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(ConfigsServiceApplication.class, args);
	}

}
