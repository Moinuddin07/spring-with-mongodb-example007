package com.example.spring.with.mongo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

@SpringBootApplication
@ComponentScan(basePackages = "com.example.spring")
public class SpringWithMongoDbApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringWithMongoDbApplication.class, args);
	}

}
