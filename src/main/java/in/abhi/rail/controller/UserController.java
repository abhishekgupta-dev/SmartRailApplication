package in.abhi.rail.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import in.abhi.rail.DTO.UserRequest;
import in.abhi.rail.DTO.UserResponse;
import in.abhi.rail.entity.User;
import in.abhi.rail.service.UserService;
import jakarta.validation.Valid;

@RestController
@RequestMapping("api/users")
public class UserController {
	
	private final UserService userService;
	
	public UserController(UserService userService) {
		
		this.userService=userService;
	}
	
	@PostMapping
	public User createUser(@Valid @RequestBody UserRequest request) {
		
		return userService.saveUser(request);
	}
	
	@GetMapping
	public List<UserResponse> getAllUser( ){
		
		return userService.getAllUsers();
	}
	
	@GetMapping("/{id}")
	public UserResponse getUserById(@PathVariable Long id) {
		
		return userService.getUserById(id);
	}
	
	@PutMapping("/{id}")
	public UserResponse updateUser(
			@PathVariable Long id ,
			@Valid @RequestBody UserRequest request) {
		
		return userService.updateUser(id,request);
	}
	
	@DeleteMapping("/{id}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void deleteUser(@PathVariable Long id ) {
		
		userService.deleteUser(id);
	}

}
