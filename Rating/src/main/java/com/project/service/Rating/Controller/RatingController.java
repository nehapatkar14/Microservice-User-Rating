package com.project.service.Rating.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.project.service.Rating.Entities.Ratings;
import com.project.service.Rating.Services.RatingService;

@RestController
@RequestMapping("/ratings")
public class RatingController {
	@Autowired
    private RatingService ratingService;
	
	@PostMapping
    public ResponseEntity<Ratings> create(@RequestBody Ratings rating) {
        return ResponseEntity.status(HttpStatus.CREATED).body(ratingService.create(rating));
    }
	 @GetMapping
	    public ResponseEntity<List<Ratings>> getRatings() {
	        return ResponseEntity.ok(ratingService.getRatings());
	    }
	 @GetMapping("/users/{userId}")
	    public ResponseEntity<List<Ratings>> getRatingsByUserId(@PathVariable String userId) {
	        return ResponseEntity.ok(ratingService.getRatingByUserId(userId));
	    }
	  @GetMapping("/hotels/{hotelId}")
	 public ResponseEntity<List<Ratings>> getRatingsByHotelId(@PathVariable String hotelId) {
	        return ResponseEntity.ok(ratingService.getRatingByHotelId(hotelId));
	    }
}
