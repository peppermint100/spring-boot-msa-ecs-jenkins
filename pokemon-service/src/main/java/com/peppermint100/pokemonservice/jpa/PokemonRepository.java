package com.peppermint100.pokemonservice.jpa;

import com.peppermint100.pokemonservice.dto.PokemonType;
import org.springframework.data.repository.CrudRepository;

public interface PokemonRepository extends CrudRepository<Pokemon, Integer> {
    Iterable<Pokemon> getPokemonsByType(PokemonType type);
}
