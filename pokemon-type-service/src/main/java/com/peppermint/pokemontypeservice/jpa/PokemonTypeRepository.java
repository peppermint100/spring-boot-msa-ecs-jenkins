package com.peppermint.pokemontypeservice.jpa;

import org.springframework.data.repository.CrudRepository;

public interface PokemonTypeRepository extends CrudRepository<PokemonType, Integer> {
    String findByName(String name);
}
