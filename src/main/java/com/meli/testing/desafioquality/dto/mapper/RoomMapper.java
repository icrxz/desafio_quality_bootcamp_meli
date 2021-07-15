package com.meli.testing.desafioquality.dto.mapper;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import com.meli.testing.desafioquality.dto.room.RoomDTO;
import com.meli.testing.desafioquality.entity.Room;
import com.meli.testing.desafioquality.form.RoomForm;

public class RoomMapper {

	public static List<RoomDTO> convert(List<Room> room) {
		return room.stream().map(RoomDTO::new).collect(Collectors.toList());
	}

	public static List<RoomDTO> convertRoomListToDTO(List<Room> rooms) {
		return rooms.stream().map(RoomDTO::new).collect(Collectors.toList());
	}

	public static List<Room> convertRoomFormToForm(List<RoomForm> rooms) {
		List<Room> listRooms = new ArrayList<>();
		rooms.forEach(r -> listRooms.add(new Room(r.getRoom_name(),r.getRoom_width(), r.getRoom_length())));
		return listRooms;
	}
}
