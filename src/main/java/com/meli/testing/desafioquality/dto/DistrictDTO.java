package com.meli.testing.desafioquality.dto;

import com.meli.testing.desafioquality.entity.District;

import java.math.BigDecimal;

public class DistrictDTO {
    private long id;
    private String name;
    private BigDecimal value_m2;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public BigDecimal getValue_m2() {
        return value_m2;
    }

    public void setValue_m2(BigDecimal value_m2) {
        this.value_m2 = value_m2;
    }

    public DistrictDTO() {
    }

    public DistrictDTO(District district) {
        this.id = district.getId();
        this.name = district.getName();
        this.value_m2 = district.getValue_m2();
    }
}
