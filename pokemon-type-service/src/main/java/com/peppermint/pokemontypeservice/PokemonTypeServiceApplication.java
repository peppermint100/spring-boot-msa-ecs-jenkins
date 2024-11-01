package com.peppermint.pokemontypeservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class PokemonTypeServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(PokemonTypeServiceApplication.class, args);
    }

}
