package com.project.accounts;

import io.swagger.v3.oas.annotations.ExternalDocumentation;
import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Contact;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.info.License;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing(auditorAwareRef = "auditAwareImpl")
@OpenAPIDefinition(
		info = @Info(
				title =  "Accounts Microservice REST API Documentation",
				description = "Practice Project REST API using Java - Spring",
				version = "v1",
				contact = @Contact(
						name = "Roj",
						url  = "",
						email = "rojjamescarranza@gmail.com"
				),
				license = @License(
						name = "Apache 2.0",
						url = ""
				)
		),
		externalDocs = @ExternalDocumentation(
				description = "Accounts Microservice REST API Documentation",
				url = ""
		)

)
public class AccountsApplication {

	public static void main(String[] args) {
		SpringApplication.run(AccountsApplication.class, args);
	}

}
