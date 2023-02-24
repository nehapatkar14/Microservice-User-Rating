package com.project.service.Rating.ServicesImpl;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.service.Rating.Entities.Ratings;
import com.project.service.Rating.Services.RatingService;
import com.project.service.Rating.repositories.RatingRepo;

@Service
public class RatingServiceImpl implements RatingService{
	   @Autowired
	    private RatingRepo repository;

	    @Override
	    public Ratings create(Ratings rating) {
	    	String randomUserId = UUID.randomUUID().toString();
			 rating.setRatingId(randomUserId);
	        return repository.save(rating);
	    }

	    @Override
	    public List<Ratings> getRatings() {
	        return repository.findAll();
	    }

	    @Override
	    public List<Ratings> getRatingByUserId(String userId) {
	        return repository.findByuserId(userId);
	    }

	    @Override
	    public List<Ratings> getRatingByHotelId(String hotelId) {
	        return repository.findByhotelId(hotelId);
	       
	    }

		
}
