package com.peppermint.pokemontypeservice.vo;

import com.peppermint.pokemontypeservice.jpa.PokemonType;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class ResponsePokemonType {
    private String name;

    public static ResponsePokemonType fromEntity(PokemonType entity) {
        return new ResponsePokemonType(entity.getName());
    }
}
