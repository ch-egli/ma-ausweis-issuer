package ch.sbb.iam;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

@SpringBootApplication
@EnableCaching
public class MAAusweisIssuerApplication {

	public static void main(String[] args) {
		SpringApplication.run(MAAusweisIssuerApplication.class, args);
	}

}
