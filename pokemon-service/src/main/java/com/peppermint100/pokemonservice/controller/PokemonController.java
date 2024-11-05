package com.peppermint100.pokemonservice.controller;

import com.peppermint100.pokemonservice.client.PokemonTypeClient;
import com.peppermint100.pokemonservice.dto.PokemonType;
import com.peppermint100.pokemonservice.jpa.Pokemon;
import com.peppermint100.pokemonservice.service.PokemonService;
import com.peppermint100.pokemonservice.vo.ResponsePokemon;
import com.peppermint100.pokemonservice.vo.ResponsePokemonType;
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
    private final PokemonTypeClient pokemonTypeClient;

    @GetMapping("/pokemons/{type}")
    public ResponseEntity<List<ResponsePokemon>> getPokemonsByType(
            @PathVariable Optional<PokemonType> type
            ) {
        List<ResponsePokemon> result = new ArrayList<>();

        if (type.isEmpty()) {
            return ResponseEntity.status(HttpStatus.OK).body(result);
        }

        PokemonType requestPokemonType = type.get();
        List<ResponsePokemonType> allPokemonTypes = pokemonTypeClient.getAllPokemonTypes();

        List<PokemonType> validPokemonTypes = allPokemonTypes.stream().map(responsePokemonType -> {
            Optional<PokemonType> pokemonTypeOptional = PokemonType.fromString(responsePokemonType.getName());
            return pokemonTypeOptional.orElse(null);
        }).toList();

        if (!validPokemonTypes.contains(requestPokemonType)) {
            return ResponseEntity.status(HttpStatus.OK).body(result);
        }

        Iterable<Pokemon> pokemonEntities = service.getPokemonByType(requestPokemonType);

        for (Pokemon entity : pokemonEntities) {
            result.add(ResponsePokemon.fromEntity(entity));
        }

        return ResponseEntity.status(HttpStatus.OK).body(result);
    }
}
