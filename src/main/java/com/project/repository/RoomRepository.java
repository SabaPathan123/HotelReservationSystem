package com.project.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.project.dto.Room;

public interface RoomRepository extends JpaRepository<Room, Integer>{

}
