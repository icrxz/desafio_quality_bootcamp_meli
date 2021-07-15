package com.meli.testing.desafioquality.utils;

import com.meli.testing.desafioquality.entity.Room;

public class CalculateRoom {

    public static Double calculateArea(Room room) {
        return room.getWidth() * room.getLength();
    }
}
