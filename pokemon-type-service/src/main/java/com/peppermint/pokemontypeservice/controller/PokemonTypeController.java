package com.peppermint.pokemontypeservice.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class PokemonTypeController {

    private final Environment env;

    @GetMapping("/hello")
    public String hello() {
        System.out.println("hello world");
        return env.getProperty("test.hello");
    }
}
