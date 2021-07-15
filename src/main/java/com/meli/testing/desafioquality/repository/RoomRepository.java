package com.meli.testing.desafioquality.repository;

import com.meli.testing.desafioquality.entity.Room;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoomRepository extends JpaRepository<Room, Long> {
}
