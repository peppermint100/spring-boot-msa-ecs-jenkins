package com.peppermint100.pokemonservice.vo;

import lombok.Data;

@Data
public class RequestCreatePokemon {
    private String name;
    private String type;
}
