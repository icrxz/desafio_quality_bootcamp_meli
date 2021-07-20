package com.meli.testing.desafioquality.dto.mapper;

import java.util.List;
import java.util.stream.Collectors;
import com.meli.testing.desafioquality.dto.property.PropertyDTO;
import com.meli.testing.desafioquality.dto.property.PropertyRoomsM2DTO;
import com.meli.testing.desafioquality.dto.room.RoomMt2DTO;
import com.meli.testing.desafioquality.entity.District;
import com.meli.testing.desafioquality.entity.Property;
import com.meli.testing.desafioquality.form.PropertyForm;

public class PropertyMapper {

	public static List<PropertyDTO> convert(List<Property> property) {
		return property.stream().map(PropertyDTO::new).collect(Collectors.toList());
	}

	public static PropertyRoomsM2DTO convert(Property property, List<RoomMt2DTO> listRoom) {
		return new PropertyRoomsM2DTO(property.getName(), listRoom);
	}

	public static PropertyDTO convert(Property property) {
		return new PropertyDTO(property);
	}

	public static Property convert(PropertyForm property, District district) {
		return new Property(property.getProp_name(), district, RoomMapper.convertRoomFormToForm(property.getRooms()));
	}
}
