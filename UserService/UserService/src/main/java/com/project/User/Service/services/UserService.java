package com.project.User.Service.services;

import java.util.List;

import com.project.User.Service.Entities.User;

public interface UserService {

	  User saveUser(User user);

	    //get all user
	    List<User> getAllUser();

	    //get single user of given userId

	    User getUser(String userId);
}
