package com.project.service.Rating.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.project.service.Rating.Entities.Ratings;

public interface RatingRepo extends JpaRepository<Ratings,String> {

	List<Ratings> findByuserId(String userId);

	List<Ratings> findByhotelId(String hotelId);

}
