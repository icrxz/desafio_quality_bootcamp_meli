package com.meli.testing.desafioquality.utils;

import com.meli.testing.desafioquality.entity.Property;
import com.meli.testing.desafioquality.entity.Room;


public class CalculateArea {

    public static Double calculateRoom(Room room) {
        return room.getWidth() * room.getLength();
    }

    public static Double calculateProperty(Property property) {
        return property.getRooms().stream().mapToDouble(CalculateArea::calculateRoom).sum();
    }
}
