package com.meli.testing.desafioquality.utils;

import com.meli.testing.desafioquality.entity.Room;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class UtilCalculateRoomTest {
    private Room mockedRoom;

    public Room createRoom() {
        return new Room("Quarto 1", 4.6, 3.5);
    }

    @BeforeEach
    public void init() {
        this.mockedRoom = createRoom();
    }

    @Test
    public void shouldCalculateRoomArea() {
        double expectedArea = (4.6 * 3.5);
        double calculatedArea = CalculateRoom.calculateArea(mockedRoom);

        Assertions.assertEquals(expectedArea, calculatedArea);
    }

    @Test
    public void shouldNotCalculateRoomsArea() {
        double wrongArea = (4.6 * 3.4);
        double calculatedArea = CalculateRoom.calculateArea(mockedRoom);

        Assertions.assertNotEquals(wrongArea, calculatedArea);
    }
}
