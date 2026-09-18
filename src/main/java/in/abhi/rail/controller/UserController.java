package in.abhi.rail.controller;

import java.time.LocalDateTime;
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
import in.abhi.rail.payload.ApiResponse;
import in.abhi.rail.service.UserService;
import jakarta.validation.Valid;

@RestController
@RequestMapping("api/users")
public class UserController {
	
	private final UserService userService;
	
	public UserController(UserService userService) {
		
		this.userService=userService;
	}
	//===========================================post =====================================
	@PostMapping
	public ResponseEntity<ApiResponse<UserResponse>> createUser(@Valid @RequestBody UserRequest request) {
		
		UserResponse user = userService.saveUser(request);
		
		ApiResponse<UserResponse> response = new ApiResponse<>(
				true,
				LocalDateTime.now(),
				HttpStatus.OK.value(),
				"User save  Successfuly",
				user);
		return ResponseEntity.ok(response);
	}
	//================================All user ====================================
	@GetMapping
	public ResponseEntity<ApiResponse<List<UserResponse>>> getAllUser( ){
		
		List<UserResponse> user = userService.getAllUsers();
		ApiResponse<List<UserResponse>>response = new ApiResponse<>(
				true,
				LocalDateTime.now(),
				HttpStatus.OK.value(),
				" All User Fatch Successfuly",
				user);
		return ResponseEntity.ok(response);
	}
	//===================================by id ========================================
	@GetMapping("/{id}")
	public ResponseEntity<ApiResponse<UserResponse>> getUserById(@PathVariable Long id) {
		
       UserResponse user = userService.getUserById(id);
		
		if(user==null) {
			ResponseEntity.notFound().build();
		}
		
		ApiResponse<UserResponse> response = new ApiResponse<>(
				true,
				LocalDateTime.now(),
				HttpStatus.OK.value(),
				"User Fatch Successfuly",
				user);
		return ResponseEntity.ok(response);
	}
	//=============================================Update=============================
	@PutMapping("/{id}")
	public ResponseEntity<ApiResponse<UserResponse>> updateUser(
			@PathVariable Long id ,
			@Valid @RequestBody UserRequest request) {
		
        UserResponse user = userService.updateUser(id,request);
		
		ApiResponse<UserResponse> response = new ApiResponse<>(
				true,
				LocalDateTime.now(),
				HttpStatus.OK.value(),
				"User Updated  Successfuly",
				user);
		return ResponseEntity.ok(response);
		
	}
	//========================================DElete===================================
	@DeleteMapping("/{id}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public ResponseEntity<ApiResponse<Object>> deleteUser(@PathVariable Long id ) {
		
		userService.deleteUser(id);
		ApiResponse<Object> response = new ApiResponse<>(
				true,
				LocalDateTime.now(),
				HttpStatus.OK.value(),
				"User Deleted  Successfuly",
			null);
		return ResponseEntity.ok(response);
	}

}
