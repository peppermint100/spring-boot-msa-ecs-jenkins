package com.peppermint.pokemontypeservice.controller;

import com.peppermint.pokemontypeservice.PokemonTypeServiceApplication;
import com.peppermint.pokemontypeservice.jpa.PokemonType;
import com.peppermint.pokemontypeservice.service.PokemonTypeService;
import com.peppermint.pokemontypeservice.vo.ResponsePokemonType;
import lombok.RequiredArgsConstructor;
import org.apache.coyote.Response;
import org.springframework.core.env.Environment;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequiredArgsConstructor
public class PokemonTypeController {

    private final Environment env;
    private final PokemonTypeService service;

    @GetMapping("/hello")
    public String hello() {
        System.out.println("hello world");
        return env.getProperty("test.hello");
    }

    @GetMapping("/pokemon-types")
    public ResponseEntity<List<ResponsePokemonType>> getAllPokemonTypes() {
        Iterable<PokemonType> pokemonTypeEntities = service.getAllPokemonTypes();
        List<ResponsePokemonType> result = new ArrayList<>();
        for (PokemonType entity : pokemonTypeEntities) {
            result.add(ResponsePokemonType.fromEntity(entity));
        }
        return ResponseEntity.status(HttpStatus.OK).body(result);
    }
}
