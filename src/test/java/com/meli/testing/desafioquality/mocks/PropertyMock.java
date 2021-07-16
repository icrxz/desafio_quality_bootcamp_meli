package com.meli.testing.desafioquality.mocks;

import com.meli.testing.desafioquality.entity.District;
import com.meli.testing.desafioquality.entity.Property;
import com.meli.testing.desafioquality.entity.Room;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class PropertyMock {

    public static Property create() {
        District district = new District("any_district_name", new BigDecimal(100.00), null);
        List<Room> rooms = new ArrayList<>(){
            { add(new Room("any_description", 10.0, 10.0)); }
            { add(new Room("any_description", 10.0, 10.0)); }
        };
        Property property = new Property("any_property_name", district, rooms);
        property.setId(1L);
        return property;
    }
}
