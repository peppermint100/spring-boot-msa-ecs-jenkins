package com.peppermint100.pokemonservice.client;

import com.peppermint100.pokemonservice.vo.ResponsePokemonType;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

//@FeignClient(name = "pokemon-type-service", url = "${pokemon-type-service-url}")
public interface PokemonTypeClient {

    @GetMapping("/pokemon-types")
    List<ResponsePokemonType> getAllPokemonTypes();
}
