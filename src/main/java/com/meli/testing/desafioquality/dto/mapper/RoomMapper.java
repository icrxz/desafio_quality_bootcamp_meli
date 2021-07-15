package com.meli.testing.desafioquality.dto.mapper;

import java.util.List;
import java.util.stream.Collectors;
import com.meli.testing.desafioquality.dto.RoomDTO;
import com.meli.testing.desafioquality.entity.Room;

public class RoomMapper {

	public static List<RoomDTO> converter(List<Room> room) {

		return room.stream().map(RoomDTO::new).collect(Collectors.toList());
	}

	public static List<RoomDTO> convertRoomListToDTO(List<Room> rooms) {
		return rooms.stream().map(RoomDTO::new).collect(Collectors.toList());
	}
}
