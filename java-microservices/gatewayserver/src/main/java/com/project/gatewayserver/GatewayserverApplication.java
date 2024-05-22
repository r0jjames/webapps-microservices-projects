package com.project.gatewayserver;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;

import java.time.LocalDateTime;

@SpringBootApplication
public class GatewayserverApplication {

	public static void main(String[] args) {
		SpringApplication.run(GatewayserverApplication.class, args);
	}

/*	example usage:
	http://localhost:8072/rudzbank/accounts/api/create
	http://localhost:8072/rudzbank/cards/api/create
	http://localhost:8072/rudzbank/loans/api/create
*/
	@Bean
	public RouteLocator customRouteConfig(RouteLocatorBuilder routeLocatorBuilder) {
		return routeLocatorBuilder.routes()
				.route(p -> p
						.path("/rudzbank/accounts/**")
						.filters(f -> f.rewritePath("/rudzbank/accounts/(?<segment>.*)", "/${segment}")
								.addResponseHeader("X-Response-Time", LocalDateTime.now().toString()))
						.uri("lb://ACCOUNTS"))
				.route(p -> p
						.path("/rudzbank/cards/**")
						.filters(f -> f.rewritePath("/rudzbank/cards/(?<segment>.*)", "/${segment}")
								.addResponseHeader("X-Response-Time", LocalDateTime.now().toString()))
						.uri("lb://CARDS"))
				.route(p -> p
						.path("/rudzbank/loans/**")
						.filters(f -> f.rewritePath("/rudzbank/loans/(?<segment>.*)", "/${segment}")
								.addResponseHeader("X-Response-Time", LocalDateTime.now().toString()))
						.uri("lb://LOANS")).build();

	}

}
