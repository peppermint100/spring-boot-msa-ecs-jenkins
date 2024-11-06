package com.peppermint100.pokemonservice.jpa;

import com.peppermint100.pokemonservice.vo.RequestCreatePokemon;
import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "pokemon")
@AllArgsConstructor
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
public class Pokemon {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "name", unique = true)
    private String name;

    @Column(name = "type")
    private String type;

    protected Pokemon(String name, String type) {
        this.name = name;
        this.type = type;
    }

    public static Pokemon from(RequestCreatePokemon request) {
        return new Pokemon(request.getName(), request.getType());
    }
}
