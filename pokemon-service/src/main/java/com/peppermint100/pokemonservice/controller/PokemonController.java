package com.peppermint100.pokemonservice.controller;

import com.peppermint100.pokemonservice.dto.PokemonType;
import com.peppermint100.pokemonservice.jpa.Pokemon;
import com.peppermint100.pokemonservice.service.PokemonService;
import com.peppermint100.pokemonservice.vo.ResponsePokemon;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
@RequiredArgsConstructor
public class PokemonController {

    private final PokemonService service;

    @GetMapping("/pokemons/{type}")
    public ResponseEntity<List<ResponsePokemon>> getPokemonsByType(
            @PathVariable Optional<PokemonType> type
            ) {
        List<ResponsePokemon> result = new ArrayList<>();

        if (type.isEmpty()) {
            return ResponseEntity.status(HttpStatus.OK).body(result);
        }

        Iterable<Pokemon> pokemonEntities = service.getPokemonByType(type.get());
        for (Pokemon entity : pokemonEntities) {
            result.add(ResponsePokemon.fromEntity(entity));
        }

        return ResponseEntity.status(HttpStatus.OK).body(result);
    }
}
