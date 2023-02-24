package com.project.User.Service.services.impl;

import java.util.Arrays;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

import org.hibernate.annotations.common.util.impl.LoggerFactory;
import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.google.inject.spi.PrivateElements;
import com.project.User.Service.Entities.Hotel;
import com.project.User.Service.Entities.Rating;
import com.project.User.Service.Entities.User;
import com.project.User.Service.Exceptions.UserNotFoundException;
import com.project.User.Service.Repositories.UserRepo;
import com.project.User.Service.externalServices.HotelService;
import com.project.User.Service.services.UserService;
import com.project.User.Service.Exceptions.*;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UserRepo userRepo;
	@Autowired
	private RestTemplate restTemplate;
	
	  @Autowired
	    private HotelService hotelService;

 //   private Logger logger = LoggerFactory.getLogger(UserServiceImpl.class);
	@Override
	public User saveUser(User user) {
		// TODO Auto-generated method stub
		String randomUserId = UUID.randomUUID().toString();
		 user.setUserId(randomUserId);
		 System.out.println("name:"+user.getName());
		 System.out.println("email:"+user.getEmail());
		return userRepo.save(user);
	}

	@Override
	public List<User> getAllUser() {
		// TODO Auto-generated method stub
		return userRepo.findAll();
	}

	@Override
	public User getUser(String userId) {
		// TODO Auto-generated method stub

        User user = userRepo.findById(userId).orElseThrow(() -> new UserNotFoundException());
		  Rating[] ratingsOfUser = restTemplate.getForObject("http://RATING-SERVICE/ratings/users/" + user.getUserId(), Rating[].class);
		  	//logger.info("{} ", ratingsOfUser);
	        List<Rating> ratings = Arrays.stream(ratingsOfUser).toList();
	        List<Rating> ratingList = ratings.stream().map(rating -> {
	            //api call to hotel service to get the hotel
	            //http://localhost:8082/hotels/1cbaf36d-0b28-4173-b5ea-f1cb0bc0a791
//	            ResponseEntity<Hotel> forEntity = restTemplate.getForEntity("http://HOTEL-SERVICE/hotels/"+rating.getHotelId(), Hotel.class);
//	            Hotel hotel = forEntity.getBody();
	            Hotel hotel = hotelService.getHotel(rating.getHotelId());
	            // logger.info("response status code: {} ",forEntity.getStatusCode());
	            //set the hotel to rating
	            rating.setHotel(hotel);
	            //return the rating
	            return rating;
	        }).collect(Collectors.toList());
	        user.setRatings(ratingList);

		  return userRepo.findById(userId).orElseThrow(()->new UserNotFoundException());
	}

}
