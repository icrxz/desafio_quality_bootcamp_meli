package com.meli.testing.desafioquality.form;

import javax.validation.constraints.Digits;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.math.BigDecimal;

public class DistrictForm {
    private Long id;

    @NotNull(message = "O Bairro não pode estar vazio.")
    @Size(max = 45, message = "O comprimento do bairro não pode exceder 45 caracteres.")
    private String district_name;

    @NotNull(message = "O valor do metro quadrado não pode estar vazio")
    @Digits(integer = 11, fraction = 2, message = "O comprimento do valor de metro quadrado não pode exceder 13 dígitos")
    private BigDecimal value_district_m2;

    public Long getId() {
        return id;
    }

    public String getDistrict_name() {
        return district_name;
    }

    public BigDecimal getValue_district_m2() {
        return value_district_m2;
    }

    public DistrictForm() {
    }

    public DistrictForm(String district_name, BigDecimal value_district_m2) {
        this.district_name = district_name;
        this.value_district_m2 = value_district_m2;
    }
}
