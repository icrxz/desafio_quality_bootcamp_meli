package com.meli.testing.desafioquality.entity;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

@Entity
public class District {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotNull
    private String name;
    @NotNull
    private BigDecimal value_m2;
    @OneToMany(mappedBy = "district")
    private List<Property> acres = new ArrayList<>();

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
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

    public List<Property> getAcres() {
        return acres;
    }

    public void setAcres(List<Property> acres) {
        this.acres = acres;
    }

    public District() {
    }

    public District(@NotNull String name, @NotNull BigDecimal value_m2, List<Property> acres) {
        this.name = name;
        this.value_m2 = value_m2;
        this.acres = acres;
    }
}
