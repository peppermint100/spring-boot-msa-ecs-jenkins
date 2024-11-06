package com.peppermint.pokemontypeservice.messagequeue;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.peppermint.pokemontypeservice.jpa.PokemonType;
import com.peppermint.pokemontypeservice.jpa.PokemonTypeRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
@RequiredArgsConstructor
@Slf4j
public class PokemonTypeConsumer {

    private final PokemonTypeRepository pokemonTypeRepository;

    @KafkaListener(topics = "create-pokemon-type")
    public void createPokemonType(String kafkaMessage) {
        log.info("Kafka Message = {}", kafkaMessage);
        Map<Object, Object> map = new HashMap<>();
        ObjectMapper mapper = new ObjectMapper();
        try {
            map = mapper.readValue(kafkaMessage, new TypeReference<Map<Object, Object>>() {});
        } catch (JsonProcessingException ex) {
            ex.printStackTrace();
        }

        String typeName = (String) map.get("type");
        PokemonType pokemonTypeEntity = PokemonType.of(typeName);
        pokemonTypeRepository.save(pokemonTypeEntity);
    }
}
