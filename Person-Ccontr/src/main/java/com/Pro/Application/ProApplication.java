package com.Pro.Application;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@ComponentScan(basePackages={"com.Pro.Controller"})
@EntityScan("com.Pro.Controller")
@EnableJpaRepositories("com.Pro.Controller")
public class ProApplication {

	public static void main(String[] args) {
		SpringApplication.run(ProApplication.class, args);
	}

}
