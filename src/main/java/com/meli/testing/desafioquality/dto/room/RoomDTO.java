package com.meli.testing.desafioquality.dto.room;

import com.meli.testing.desafioquality.entity.Room;

public class RoomDTO {

	private String room_name;

	private Double room_width;

	private Double room_length;

	public RoomDTO(Room room) {
		this.room_name = room.getName();
		this.room_width = room.getWidth();
		this.room_length = room.getLength();
	}

	public String getRoom_name() {
		return room_name;
	}

	public void setRoom_name(String room_name) {
		this.room_name = room_name;
	}

	public Double getRoom_width() {
		return room_width;
	}

	public void setRoom_width(Double room_width) {
		this.room_width = room_width;
	}

	public Double getRoom_length() {
		return room_length;
	}

	public void setRoom_length(Double room_length) {
		this.room_length = room_length;
	}
}