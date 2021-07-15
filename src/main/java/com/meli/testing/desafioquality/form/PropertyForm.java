package com.meli.testing.desafioquality.form;

import com.meli.testing.desafioquality.entity.Room;

import javax.validation.Valid;
import javax.validation.constraints.Max;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import java.math.BigDecimal;
import java.util.List;

public class PropertyForm {
    @NotNull(message = "O nome da propriedade não pode estar vazio.")
    @Pattern(regexp = "^([A-Z]+[a-zA-Z\\s]*)+$", message = "O nome da propriedade deve começar com uma letra maiúscula.")
    @Max(value = 30, message = "O comprimento do nome não pode exceder 30 caracteres.")
    private String prop_name;

    @NotNull(message = "O Bairro não pode estar vazio.")
    @Max(value = 45, message = "O comprimento do bairro não pode exceder 45 caracteres.")
    private String prop_district;

    @NotNull(message = "O valor do metro quadrado não pode estar vazio")
    @Max(value = 13, message = "O comprimento do valor de metro quadrado não pode exceder 13 dígitos")
    private BigDecimal value_district_m2;

    @Valid
    @NotEmpty(message = "Os cômodos dos imóveis deverão ser informados")
    private List<Room> rooms;

    public PropertyForm(String prop_name, String prop_district, BigDecimal value_district_m2, List<Room> rooms) {
        this.prop_name = prop_name;
        this.prop_district = prop_district;
        this.value_district_m2 = value_district_m2;
        this.rooms = rooms;
    }

    public String getProp_name() {
        return prop_name;
    }

    public String getProp_district() {
        return prop_district;
    }

    public BigDecimal getValue_district_m2() {
        return value_district_m2;
    }

    public List<Room> getRooms() {
        return rooms;
    }
}
