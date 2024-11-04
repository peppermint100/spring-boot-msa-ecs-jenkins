package com.peppermint.pokemontypeservice.jpa;

import jakarta.persistence.*;
import lombok.Getter;

@Entity
@Table(name = "pokemon_type")
@Getter
public class PokemonType {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "name")
    private String name;
}
