package com.meli.testing.desafioquality.dto.property;

import com.fasterxml.jackson.annotation.JsonInclude;

import java.math.BigDecimal;

public class PropertyM2DTO {
    private String prop_name;
    private Double prop_m2;

    @JsonInclude(JsonInclude.Include.NON_NULL)
    private BigDecimal prop_value;

    public PropertyM2DTO(String prop_name, Double prop_m2) {
        this.prop_name = prop_name;
        this.prop_m2 = prop_m2;
    }

    public String getProp_name() {
        return prop_name;
    }

    public void setProp_name(String prop_name) {
        this.prop_name = prop_name;
    }

    public Double getProp_m2() {
        return prop_m2;
    }

    public void setProp_m2(Double prop_m2) {
        this.prop_m2 = prop_m2;
    }

    public BigDecimal getProp_value() {
        return prop_value;
    }

    public void setProp_value(BigDecimal prop_value) {
        this.prop_value = prop_value;
    }
}
