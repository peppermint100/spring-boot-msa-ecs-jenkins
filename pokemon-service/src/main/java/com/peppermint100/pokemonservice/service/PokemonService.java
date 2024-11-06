package com.peppermint100.pokemonservice.service;

import com.peppermint100.pokemonservice.jpa.Pokemon;
import com.peppermint100.pokemonservice.jpa.PokemonRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class PokemonService {

    private final PokemonRepository repository;

    public Iterable<Pokemon> getPokemonByType(String type) {
        return repository.getPokemonsByType(type);
    }

    public Pokemon addPokemon(Pokemon pokemon) {
        return repository.save(pokemon);
    }
}
