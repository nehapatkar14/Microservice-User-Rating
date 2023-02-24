package com.project.Hotel.Service.Exception;

import net.bytebuddy.implementation.bind.annotation.Super;

public class HotelNotFoundException extends RuntimeException{

 public HotelNotFoundException(){
		// TODO Auto-generated constructor stub
		super("Hotel not found");
	}
}

