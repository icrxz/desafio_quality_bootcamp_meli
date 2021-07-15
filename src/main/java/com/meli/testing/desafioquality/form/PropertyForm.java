package com.meli.testing.desafioquality.form;

import javax.validation.Valid;
import javax.validation.constraints.*;
import java.util.List;

public class PropertyForm {
    @NotNull(message = "O nome da propriedade não pode estar vazio.")
    @Pattern(regexp = "^([A-Z]+[a-zA-Z\\s]*)+$", message = "O nome da propriedade deve começar com uma letra maiúscula.")
    @Size(max = 30, message = "O comprimento do nome não pode exceder 30 caracteres.")
    private String prop_name;

    @Valid
    @NotNull(message = "O Bairro não pode estar vazio.")
    private Long prop_district_id;

    @Valid
    @NotEmpty(message = "Os cômodos dos imóveis deverão ser informados")
    private List<RoomForm> rooms;

    public PropertyForm(String prop_name, Integer prop_district, List<RoomForm> rooms) {
        this.prop_name = prop_name;
        this.rooms = rooms;
    }

    public String getProp_name() {
        return prop_name;
    }

    public Long getProp_district_id() {
        return prop_district_id;
    }

    public List<RoomForm> getRooms() {
        return rooms;
    }
}
