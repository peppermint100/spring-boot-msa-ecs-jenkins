package com.peppermint100.pokemonservice.vo;

import com.peppermint100.pokemonservice.validation.PokemonType;
import jakarta.validation.constraints.*;
import lombok.Getter;

@Getter
public class CreatePokemonRequest {

    @Pattern(
            regexp = "^[A-Z]+-[0-9]{3}$",
            message = "SerialNumber의 형태가 잘못됐습니다."
    )
    @NotNull
    private String serialNumber;

    @NotNull
    @Size(min = 1, max = 10, message = "이름은 1~10자 사이로 설정해야합니다.")
    private String name;

    @NotNull
    @PokemonType
    private String type;

    @Min(value = 10, message = "최소 체력은 10입니다.")
    @Max(value = 300, message = "최대 체력은 300입니다.")
    private Integer hp;
}
