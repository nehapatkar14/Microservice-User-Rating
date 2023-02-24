package com.project.Hotel.Service.Services.Impl;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.Hotel.Service.Entities.Hotel;
import com.project.Hotel.Service.Repositories.HotelRepo;
import com.project.Hotel.Service.Services.HotelService;
import com.project.Hotel.Service.Exception.*;

@Service
public class HotelServiceImpl implements HotelService{
	
	@Autowired
	HotelRepo hotelRepo;

	@Override
	public Hotel saveHotel(Hotel hotel) {
		String randomHotelId = UUID.randomUUID().toString();
		 hotel.setHotelId(randomHotelId);
		Hotel returnedHotel= hotelRepo.save(hotel);
		return returnedHotel;
	}

	@Override
	public List<Hotel> getAllHotels() {
		List<Hotel> returnedHotel= hotelRepo.findAll();
		return returnedHotel;
	}

	@Override
	public Hotel getHotel(String hotelId) {
		Hotel returnedHotel= hotelRepo.findById(hotelId).orElseThrow(()->new HotelNotFoundException());
		return returnedHotel;
	}

}
