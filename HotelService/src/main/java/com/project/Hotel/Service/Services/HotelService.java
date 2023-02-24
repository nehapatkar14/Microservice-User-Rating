package com.project.Hotel.Service.Services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.project.Hotel.Service.Entities.Hotel;

@Service
public interface HotelService {
	
	Hotel saveHotel(Hotel hotel);

    
    List<Hotel> getAllHotels();

    

    Hotel getHotel(String hotelId);

}
