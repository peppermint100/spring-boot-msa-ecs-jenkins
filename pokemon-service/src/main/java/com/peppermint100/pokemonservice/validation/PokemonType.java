package com.peppermint100.pokemonservice.validation;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Constraint(validatedBy = PokemonTypeValidator.class)
@Target({ ElementType.FIELD, ElementType.PARAMETER })
@Retention(RetentionPolicy.RUNTIME)
public @interface PokemonType {
    String message() default "Invalid code format. Expected: UPPERCASE-123";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};
}
