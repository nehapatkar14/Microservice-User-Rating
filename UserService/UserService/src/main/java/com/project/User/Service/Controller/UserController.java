package com.project.User.Service.Controller;

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

import com.project.User.Service.Entities.User;
import com.project.User.Service.services.UserService;

import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;

@RestController
@RequestMapping("/users")
public class UserController {
	
	@Autowired
	UserService userService;

	//create
	@PostMapping
	public ResponseEntity<User> createUser (@RequestBody User user) {
		User returnedUser= userService.saveUser(user);
		return ResponseEntity.status(HttpStatus.CREATED).body(returnedUser);
		
	}
	//single
	@GetMapping("/{id}")
	@CircuitBreaker(name = "ratingHotelBreaker", fallbackMethod = "ratingHotelFallback")
	public ResponseEntity<User> getUser (@PathVariable String id) {
		User returnedUser= userService.getUser(id);
		return ResponseEntity.ok(returnedUser);
		
	}
	  public ResponseEntity<User> ratingHotelFallback(String userId, Exception ex) {
//        logger.info("Fallback is executed because service is down : ", ex.getMessage());

        ex.printStackTrace();

        User user = User.builder().email("dummy@gmail.com").name("Dummy").about("This user is created dummy because some service is down").userId("141234").build();
        return new ResponseEntity<>(user, HttpStatus.BAD_REQUEST);
    }
	
	@GetMapping
	public  ResponseEntity<List<User>> getUsers() {
		List<User> returnedUser= userService.getAllUser();
		return ResponseEntity.ok(returnedUser);
		
	}
	
	//all
}
