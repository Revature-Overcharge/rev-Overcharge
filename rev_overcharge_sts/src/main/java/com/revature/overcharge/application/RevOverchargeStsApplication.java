package com.revature.overcharge.application;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@SpringBootApplication
@ComponentScan("com.revature.overcharge")
@EntityScan("com.revature.overcharge.beans")
@EnableJpaRepositories("com.revature.overcharge.repositories")
public class RevOverchargeStsApplication {

	public static void main(String[] args) {
		SpringApplication.run(RevOverchargeStsApplication.class, args);
	}

	@Bean
	public WebMvcConfigurer corsConfigurer() {
		return new WebMvcConfigurer() {
			@Override
			public void addCorsMappings(CorsRegistry registry) {
				registry.addMapping("/*").allowedOrigins("http://localhost:4200/")
						.allowedMethods("GET", "PUT", "POST", "PATCH", "DELETE").allowedHeaders("*")
						.allowCredentials(true).maxAge(3600);
				;
			}
		};
	}

}
