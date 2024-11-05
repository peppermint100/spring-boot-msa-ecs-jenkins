package com.peppermint100.pokemonservice.dto;

import com.fasterxml.jackson.annotation.JsonCreator;

import java.util.Objects;
import java.util.Optional;

/*
normal
fire
water
electrics
grass
ice
poison
 */
public enum PokemonType {
    NORMAL, FIRE, WATER, ELECTRICS, GRASS, ICE, POISON;

    public static Optional<PokemonType> fromString(String str) {
        String upperCased = str.toUpperCase();
        for (PokemonType type : PokemonType.values()) {
            if (Objects.equals(type.toString().toUpperCase(), upperCased)) {
                return Optional.of(type);
            }
        }
        return Optional.empty();
    }

    @JsonCreator
    public static PokemonType jsonCreator(String value) {
        return value == null ? null : PokemonType.valueOf(value.toUpperCase());
    }
}
