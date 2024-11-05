package com.peppermint100.pokemonservice.vo;

import com.peppermint100.pokemonservice.jpa.Pokemon;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class ResponsePokemon {
    private String name;
    private String type;

    public static ResponsePokemon fromEntity(Pokemon entity) {
        return new ResponsePokemon(entity.getName(), entity.getType().toString());
    }
}
