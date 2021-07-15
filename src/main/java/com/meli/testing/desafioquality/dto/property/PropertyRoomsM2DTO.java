package com.meli.testing.desafioquality.dto.property;

import com.meli.testing.desafioquality.dto.DistrictDTO;
import com.meli.testing.desafioquality.dto.room.RoomDTO;
import com.meli.testing.desafioquality.dto.room.RoomMt2DTO;

import java.util.List;

public class PropertyRoomsM2DTO {
    private String prop_name;
    private List<RoomMt2DTO> rooms;

    public PropertyRoomsM2DTO(String prop_name, List<RoomMt2DTO> rooms) {
        this.prop_name = prop_name;
        this.rooms = rooms;
    }

    public String getProp_name() {
        return prop_name;
    }

    public List<RoomMt2DTO> getRooms() {
        return rooms;
    }
}
