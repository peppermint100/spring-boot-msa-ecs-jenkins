package com.peppermint100.pokemonservice.vo;

import com.peppermint100.pokemonservice.dto.PokemonType;
import lombok.Data;

@Data
public class RequestCreatePokemon {
    private String name;
    private PokemonType type;
}
