package com.peppermint100.pokemonservice.jpa;

import com.peppermint100.pokemonservice.dto.PokemonType;
import jakarta.persistence.*;
import lombok.Getter;

@Entity
@Table(name = "pokemon")
@Getter
public class Pokemon {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "name", unique = true)
    private String name;

    @Column(name = "type")
    @Enumerated(EnumType.STRING)
    private PokemonType type;
}
