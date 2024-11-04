package com.peppermint.pokemontypeservice.service;

import com.peppermint.pokemontypeservice.jpa.PokemonType;
import com.peppermint.pokemontypeservice.jpa.PokemonTypeRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;


@Service
@RequiredArgsConstructor
public class PokemonTypeService {

    private final PokemonTypeRepository repository;

    public Iterable<PokemonType> getAllPokemonTypes() {
        return repository.findAll();
    }
}
