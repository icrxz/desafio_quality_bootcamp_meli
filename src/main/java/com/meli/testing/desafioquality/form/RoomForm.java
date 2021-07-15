package com.meli.testing.desafioquality.form;

import javax.validation.constraints.*;

public class RoomForm {
    @NotNull
    @NotEmpty(message = "O campo não pode estar vazio.")
    @Size(max = 30, message = "O comprimento do cômodo não pode exceder 30 caracteres.")
    @Pattern(regexp = "^([A-Z]+[a-zA-Z\\s]*)+$", message = "O nome do cômodo deve começar com uma letra maiúscula.")
    private String name;
    @NotNull(message = "A largura do cômodo não pode estar vazia.")
    @Min(value = 0)
    @Max(value = 25, message = "A largura máxima permitida por cômodo é de 25 metros.")
    private Double width;
    @NotNull(message = "O comprimento do cômodo não pode estar vazio.")
    @Min(value = 0)
    @Max(value = 33, message = "O comprimento máximo permitido por cômodo é de 33 metros.")
    private Double length;

    public String getName() {
        return name;
    }

    public Double getWidth() {
        return width;
    }

    public Double getLength() {
        return length;
    }

    public RoomForm() {
    }

    public RoomForm(String name, Double width, Double length) {
        this.name = name;
        this.width = width;
        this.length = length;
    }
}
