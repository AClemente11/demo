package com.example.demo;
import com.fasterxml.jackson.databind.PropertyNamingStrategy;
import com.fasterxml.jackson.databind.cfg.MapperConfig;
import com.fasterxml.jackson.databind.introspect.AnnotatedMethod;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.neo4j.repository.config.EnableNeo4jRepositories;
import org.springframework.http.converter.json.Jackson2ObjectMapperBuilder;
import org.springframework.scheduling.annotation.EnableScheduling;

@Configuration
@SpringBootApplication
@EnableNeo4jRepositories("com.example.demo")
@EnableScheduling
public class CrudApplication {

	public static void main(String[] args) {

		SpringApplication.run(CrudApplication.class, args);
	}
	@Bean
	Jackson2ObjectMapperBuilder objectMapperBuilder() {
		Jackson2ObjectMapperBuilder builder = new Jackson2ObjectMapperBuilder();
		builder.propertyNamingStrategy(PropertyNamingStrategy.SNAKE_CASE);

		return builder;
	}
}
