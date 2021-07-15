package com.meli.testing.desafioquality.dto.mapper;

import java.util.List;
import java.util.stream.Collectors;
import com.meli.testing.desafioquality.dto.PropertyDTO;
import com.meli.testing.desafioquality.entity.Property;

public class PropertyMapper {

	public static List<PropertyDTO> converter(List<Property> property) {
		return property.stream().map(PropertyDTO::new).collect(Collectors.toList());
	}
}
