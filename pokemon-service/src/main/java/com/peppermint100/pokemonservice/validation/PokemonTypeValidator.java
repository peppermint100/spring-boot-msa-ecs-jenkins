package com.peppermint100.pokemonservice.validation;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

import java.util.List;

public class PokemonTypeValidator implements ConstraintValidator<PokemonType, String> {

    @Override
    public boolean isValid(String value, ConstraintValidatorContext context) {
        List<String> validTypes = List.of("fire", "water", "ice", "normal");
        return validTypes.contains(value);
    }
}
