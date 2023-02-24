package com.project.Hotel.Service.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.project.Hotel.Service.Entities.Hotel;

public interface HotelRepo extends JpaRepository<Hotel, String>{
	

}
