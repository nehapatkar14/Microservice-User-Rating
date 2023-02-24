package com.project.Hotel.Service.Entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
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
@Table(name="micro_hotels")
public class Hotel {

	@Id
	@Column(name="ID")
	String hotelId ;
	
	@Column(name="NAME")
	String name;
	
	@Column(name="LOCATION")
	String location;
	
	@Column(name="ABOUT")
	String about;
	
	
}
