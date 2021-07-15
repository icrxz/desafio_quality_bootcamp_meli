package com.meli.testing.desafioquality.entity;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity
public class Room {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotNull
    private String name;
    @NotNull
    private Double width;
    @NotNull
    private Double length;

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

    public Double getWidth() {
        return width;
    }

    public void setWidth(Double width) {
        this.width = width;
    }

    public Double getLength() {
        return length;
    }

    public void setLength(Double length) {
        this.length = length;
    }

    public Room() {
    }

    public Room(@NotNull String name, @NotNull Double width, @NotNull Double length) {
        this.name = name;
        this.width = width;
        this.length = length;
    }
}
