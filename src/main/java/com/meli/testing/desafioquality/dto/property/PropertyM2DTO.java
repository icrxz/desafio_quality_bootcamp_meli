package com.meli.testing.desafioquality.dto.property;

import com.meli.testing.desafioquality.dto.room.RoomMt2DTO;


public class PropertyM2DTO {
    private String prop_name;
    private Double prop_m2;

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
}
