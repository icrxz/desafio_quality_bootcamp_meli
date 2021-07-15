package com.meli.testing.desafioquality.dto;

        import java.math.BigDecimal;
        import java.util.ArrayList;
        import java.util.List;
        import java.util.stream.Collectors;

        import com.meli.testing.desafioquality.entity.Property;
        import com.meli.testing.desafioquality.entity.Room;

public class PropertyDTO {

    private Long id;

    private String name;

    private String district;

    private BigDecimal value_district_m2;

    private List<Room> rooms = new ArrayList<>();

    public PropertyDTO(Property property) {

        this.id = property.getId();
        this.name = property.getName();
        this.district = property.getDistrict();
        this.value_district_m2 = property.getValue_district_m2();
        this.rooms = property.getRooms();
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

    public String getDistrict() {
        return district;
    }

    public void setDistrict(String district) {
        this.district = district;
    }

    public BigDecimal getValue_district_m2() {
        return value_district_m2;
    }

    public void setValue_district_m2(BigDecimal value_district_m2) {
        this.value_district_m2 = value_district_m2;
    }

    public List<Room> getRooms() {
        return rooms;
    }

    public void setRooms(List<Room> rooms) {
        this.rooms = rooms;
    }

    public static List<PropertyDTO> converter(List<Property> property) {

        return property.stream().map(PropertyDTO::new).collect(Collectors.toList());
    }

}
