package com.peppermint100.pokemonservice.service;

import com.peppermint100.pokemonservice.dto.PokemonType;
import com.peppermint100.pokemonservice.jpa.Pokemon;
import com.peppermint100.pokemonservice.jpa.PokemonRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class PokemonService {

    private final PokemonRepository repository;

    public Iterable<Pokemon> getPokemonByType(PokemonType type) {
        return repository.getPokemonsByType(type);
    }
}
