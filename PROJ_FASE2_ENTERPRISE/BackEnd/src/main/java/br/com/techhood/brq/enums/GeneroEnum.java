package br.com.techhood.brq.enums;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

import java.util.stream.Stream;

public enum GeneroEnum {

    M("Masculino"),
    F("Feminino");

    private String genero;

    GeneroEnum(String genero) {
        this.genero = genero;
    }

    @JsonValue
    public String getGenero() {
        return genero;
    }

    @JsonCreator
    public static GeneroEnum decode(final String genero) {
        return Stream.of(GeneroEnum.values()).filter(targetEnum -> targetEnum.genero.equals(genero)).findFirst().orElse(null);
    }
}
