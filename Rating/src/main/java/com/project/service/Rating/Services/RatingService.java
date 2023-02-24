package com.project.service.Rating.Services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.project.service.Rating.Entities.Ratings;

@Service
public interface RatingService {
	
	  
	    Ratings create(Ratings rating);
	
	    //get all ratings
	    List<Ratings> getRatings();

	    //get all by UserId
	    List<Ratings> getRatingByUserId(String userId);

	    //get all by hotel
	    List<Ratings> getRatingByHotelId(String hotelId);
}
