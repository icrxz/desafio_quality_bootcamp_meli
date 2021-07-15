package com.meli.testing.desafioquality.dto.property;

import java.util.List;

import com.meli.testing.desafioquality.dto.DistrictDTO;
import com.meli.testing.desafioquality.dto.room.RoomDTO;
import com.meli.testing.desafioquality.dto.mapper.DistrictMapper;
import com.meli.testing.desafioquality.dto.mapper.RoomMapper;
import com.meli.testing.desafioquality.entity.Property;

public class PropertyDTO {

    private Long id;

    private String prop_name;

    private DistrictDTO prop_district;

    private List<RoomDTO> rooms;

    public PropertyDTO(Property property) {
        this.id = property.getId();
        this.prop_name = property.getName();
        this.rooms = RoomMapper.convertRoomListToDTO(property.getRooms()) ;
        this.prop_district = DistrictMapper.convert(property.getDistrict());
    }

    public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getProp_name() {
		return prop_name;
	}

	public void setProp_name(String prop_name) {
		this.prop_name = prop_name;
	}

	public DistrictDTO getProp_district_id() {
		return prop_district;
	}

	public void setProp_district(DistrictDTO prop_district) {
		this.prop_district = prop_district;
	}

	public List<RoomDTO> getRooms() {
		return rooms;
	}

	public void setRooms(List<RoomDTO> rooms) {
		this.rooms = rooms;
	}

}
