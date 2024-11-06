package com.peppermint.pokemontypeservice.jpa;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "pokemon_type")
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class PokemonType {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "name")
    private String name;

    protected PokemonType(String name) {
        this.name = name;
    }

    public static PokemonType of(String name) {
        return new PokemonType(name);
    }
}
