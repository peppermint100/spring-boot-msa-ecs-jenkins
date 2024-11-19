package com.peppermint100.pokemonservice.controller;

import com.peppermint100.pokemonservice.client.PokemonTypeClient;
import com.peppermint100.pokemonservice.jpa.Pokemon;
import com.peppermint100.pokemonservice.messagequeue.PokemonTypeProducer;
import com.peppermint100.pokemonservice.service.PokemonService;
import com.peppermint100.pokemonservice.vo.CreatePokemonRequest;
import com.peppermint100.pokemonservice.vo.RequestCreatePokemon;
import com.peppermint100.pokemonservice.vo.ResponsePokemon;
import com.peppermint100.pokemonservice.vo.ResponsePokemonType;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
@RequiredArgsConstructor
public class PokemonController {

    private final PokemonService service;
//    private final PokemonTypeClient pokemonTypeClient;
    private final PokemonTypeProducer pokemonTypeProducer;

    @GetMapping("/pokemons/{type}")
    public ResponseEntity<List<ResponsePokemon>> getPokemonsByType(
            @PathVariable String type
            ) {
        List<ResponsePokemon> result = new ArrayList<>();

        if (type.isEmpty()) {
            return ResponseEntity.status(HttpStatus.OK).body(result);
        }

//        List<ResponsePokemonType> allPokemonTypes = pokemonTypeClient.getAllPokemonTypes();

//        List<String> validPokemonTypes = allPokemonTypes.stream().map(responsePokemonType -> responsePokemonType.getName()).toList();

//        if (!validPokemonTypes.contains(type)) {
//            return ResponseEntity.status(HttpStatus.OK).body(result);
//        }

        Iterable<Pokemon> pokemonEntities = service.getPokemonByType(type);

        for (Pokemon entity : pokemonEntities) {
            result.add(ResponsePokemon.fromEntity(entity));
        }

        return ResponseEntity.status(HttpStatus.OK).body(result);
    }

    @PostMapping("/pokemons")
    public ResponseEntity<ResponsePokemon> createNewPokemon(
            @RequestBody RequestCreatePokemon requestCreatePokemon
    ) {
        Pokemon pokemonEntity = Pokemon.from(requestCreatePokemon);
        service.addPokemon(pokemonEntity);
        ResponsePokemon result = ResponsePokemon.fromEntity(pokemonEntity);
        String type = requestCreatePokemon.getType();
        pokemonTypeProducer.send(type);
        return ResponseEntity.status(HttpStatus.CREATED).body(result);
    }

    @PostMapping("/pokemons/create")
    public ResponseEntity createPokemon(
            @RequestBody @Valid CreatePokemonRequest request
    ) {
        System.out.println(request);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }
}
