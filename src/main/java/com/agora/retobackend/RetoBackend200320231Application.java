package com.agora.retobackend;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@SpringBootApplication
@EnableJpaRepositories(basePackages = "com.agora.retobackend")
@EntityScan(basePackages = "com.agora.retobackend")
@EnableSwagger2
public class RetoBackend200320231Application {

	public static void main(String[] args) {
		SpringApplication.run(RetoBackend200320231Application.class, args);
	}

}
