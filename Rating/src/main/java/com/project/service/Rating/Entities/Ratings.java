package com.project.service.Rating.Entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity

@Table(name = "micro_ratings")
public class Ratings {
	   @Id
	   @Column(name = "ID")
	    private String ratingId;
	    private String userId;
	    private String hotelId;
	    private  int rating;
	    private  String feedback;
}
