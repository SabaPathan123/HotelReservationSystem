package com.project.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.project.dto.Hotel;


public interface HotelRepository extends JpaRepository<Hotel, Integer>{

}
