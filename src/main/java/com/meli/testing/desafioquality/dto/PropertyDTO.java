package com.meli.testing.desafioquality.dto;

        import java.math.BigDecimal;
        import java.util.ArrayList;
        import java.util.List;
        import java.util.stream.Collectors;
        import com.meli.testing.desafioquality.entity.Property;
        import com.meli.testing.desafioquality.entity.Room;

public class PropertyDTO {

    private Long id;

    private String prop_name;

    private String prop_district;

    private BigDecimal value_district_m2;

    private List<RoomDTO> rooms = new ArrayList<>();

    public PropertyDTO(Property property) {

        this.id = property.getId();
        this.prop_name = property.getName();
        this.prop_district = property.getDistrict();
        this.value_district_m2 = property.getValue_district_m2();
        this.rooms = RoomMapperproperty.getRooms();
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

	public String getProp_district() {
		return prop_district;
	}

	public void setProp_district(String prop_district) {
		this.prop_district = prop_district;
	}

	public BigDecimal getValue_district_m2() {
		return value_district_m2;
	}

	public void setValue_district_m2(BigDecimal value_district_m2) {
		this.value_district_m2 = value_district_m2;
	}

	public List<RoomDTO> getRooms() {
		return rooms;
	}

	public void setRooms(List<RoomDTO> rooms) {
		this.rooms = rooms;
	}
	 
	public static List<RoomDTO> convertRoomListToDTO(List<Room> rooms) {
	        return rooms.stream().map(RoomDTO::new).collect(Collectors.toList());
	    }
	 
	 
	public static List<PropertyDTO> converter(List<Property> property) {

        return property.stream().map(PropertyDTO::new).collect(Collectors.toList());
    }

}
