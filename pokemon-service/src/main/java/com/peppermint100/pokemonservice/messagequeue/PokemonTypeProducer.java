package com.peppermint100.pokemonservice.messagequeue;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.peppermint100.pokemonservice.vo.RequestCreatePokemonType;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
@Slf4j
@RequiredArgsConstructor
public class PokemonTypeProducer {

    private final KafkaTemplate kafkaTemplate;

    public String send(String type) {
        ObjectMapper mapper = new ObjectMapper();
        String kafkaMessage = "";
        String pokemonTypeString = type.toLowerCase();
        RequestCreatePokemonType kafkaMessageObject = new RequestCreatePokemonType(pokemonTypeString);

        try {
            kafkaMessage = mapper.writeValueAsString(kafkaMessageObject);
        } catch (JsonProcessingException ex) {
            ex.printStackTrace();
        }

        kafkaTemplate.send("create-pokemon-type", kafkaMessage);
        return type;
    }
}
