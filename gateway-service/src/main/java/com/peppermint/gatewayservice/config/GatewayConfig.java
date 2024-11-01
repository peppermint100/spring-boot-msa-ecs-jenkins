package com.peppermint.gatewayservice.config;
import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class GatewayConfig {

    @Bean
    public RouteLocator customRouteLocator(RouteLocatorBuilder builder) {
        return builder.routes()
                .route("poketype-hello", r -> r.path("/pokemon-type-service/hello")
                        .and()
                        .method("GET")
                        .filters(f -> f.rewritePath("/pokemon-type-service/(?<segment>.*)", "/${segment}"))
                        .uri("lb://POKEMON-TYPE-SERVICE"))
                .build();
    }
}
