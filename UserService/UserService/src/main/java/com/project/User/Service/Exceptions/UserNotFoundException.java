package com.project.User.Service.Exceptions;

public class UserNotFoundException extends RuntimeException {
	
 public UserNotFoundException()
 {
	 super("Resource not found on server");
 }
}
