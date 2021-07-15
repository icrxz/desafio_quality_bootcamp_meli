package com.meli.testing.desafioquality.dto;

import java.util.List;
import java.util.stream.Collectors;

import com.meli.testing.desafioquality.entity.Room;

public class RoomDTO {

    private Long id;

    private String name;

    private Double width;

    private Double length;

    public RoomDTO(Room room) {
        this.id = room.getId();
        this.name = room.getName();
        this.width = room.getWidth();
        this.length = room.getLength();
    }

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

    public static List<RoomDTO> converter(List<Room> room) {

        return room.stream().map(RoomDTO::new).collect(Collectors.toList());
    }


}