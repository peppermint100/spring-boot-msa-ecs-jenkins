package com.peppermint100.pokemonservice.jpa;

import org.springframework.data.repository.CrudRepository;

public interface PokemonRepository extends CrudRepository<Pokemon, Integer> {
    Iterable<Pokemon> getPokemonsByType(String type);
}
