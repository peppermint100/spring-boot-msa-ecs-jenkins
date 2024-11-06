package com.peppermint100.pokemonservice.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;

@Data
@Getter
@AllArgsConstructor
public class RequestCreatePokemonType {
    private String type;
}
