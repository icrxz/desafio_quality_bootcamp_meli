package com.meli.testing.desafioquality.dto.room;

import com.meli.testing.desafioquality.entity.Room;
import com.meli.testing.desafioquality.utils.CalculateRoom;

public class RoomMt2DTO {
    private String room_name;

    private Double room_mt2;

    public RoomMt2DTO(Room room) {
        this.room_name = room.getName();
        this.room_mt2 = CalculateRoom.calculateArea(room);
    }

    public String getRoom_name() {
        return room_name;
    }

    public Double getRoom_mt2() {
        return room_mt2;
    }
}
