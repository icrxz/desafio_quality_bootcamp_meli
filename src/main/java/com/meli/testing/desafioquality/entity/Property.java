package com.meli.testing.desafioquality.entity;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Property {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotNull
    private String name;
    @OneToMany(mappedBy="property")
    private List<Room> rooms = new ArrayList<>();

    @ManyToOne(optional = false)
    private District district;

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

    public List<Room> getRooms() {
        return rooms;
    }

    public void setRooms(List<Room> rooms) {
        this.rooms = rooms;
    }

    public District getDistrict() {
        return district;
    }

    public void setDistrict(District district) {
        this.district = district;
    }

    public Property() {
    }

    public Property(String name, District district, List<Room> rooms) {
        this.name = name;
        this.district = district;
        this.rooms = rooms;
    }
    
}
