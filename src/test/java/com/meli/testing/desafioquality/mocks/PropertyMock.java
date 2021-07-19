package com.meli.testing.desafioquality.mocks;

import com.meli.testing.desafioquality.entity.District;
import com.meli.testing.desafioquality.entity.Property;
import com.meli.testing.desafioquality.entity.Room;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class PropertyMock {

    public static Property create() {
        District district = new District("any_district_name", new BigDecimal(100.00));
        List<Room> rooms = new ArrayList<>(){
            { add(new Room("any_description", 10.0, 10.0)); }
            { add(new Room("any_description", 10.0, 10.0)); }
            { add(new Room("biggest_room", 15.0, 20.0)); }

        };
        Property property = new Property("any_property_name", district, rooms);
        property.setId(1L);
        return property;
    }

    public static Property createPropertyM2() {
        District district = new District("any_district_name", new BigDecimal(100.00));
        List<Room> rooms = new ArrayList<>();
        Room room1 = new Room("Banheiro", 5.0, 5.0);
        Room room2 = new Room("Quarto", 15.0, 1.0);
        Room room3 = new Room("Sala", 20.0, 15.0);
        Room room4 = new Room("Cozinha", 25.0, 20.0);
        Room room5 = new Room("Suite", 30.0, 25.0);
        rooms.add(room1);
        rooms.add(room2);
        rooms.add(room3);
        rooms.add(room4);
        rooms.add(room5);
        Property property = new Property("any_property_name", district, rooms);
        property.setId(1L);
        return property;
    }
}
