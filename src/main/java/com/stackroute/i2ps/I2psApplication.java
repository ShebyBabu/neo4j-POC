package com.stackroute.i2ps;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.neo4j.repository.config.EnableNeo4jRepositories;

@SpringBootApplication
@EnableNeo4jRepositories
public class I2psApplication {

	public static void main(String[] args) {
		SpringApplication.run(I2psApplication.class, args);
	}

}
