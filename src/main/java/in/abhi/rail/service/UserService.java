package in.abhi.rail.service;

import java.util.List;

import org.springframework.stereotype.Service;

import in.abhi.rail.DTO.UserRequest;
import in.abhi.rail.DTO.UserResponse;
import in.abhi.rail.entity.User;
import in.abhi.rail.exception.UserNotFoundException;
import in.abhi.rail.repository.UserRepository;

@Service
public class UserService {

	private final UserRepository userRepository;
	
	public UserService(UserRepository userRepository) {
		this.userRepository=userRepository;
	}
	
	public UserResponse saveUser(UserRequest request) {
		
		User user = new User();
		
		user.setName(request.getName());
		user.setEmail(request.getEmail());
		user.setPassword(request.getPassword());
		
		User savedUser =  userRepository.save(user);
		return new UserResponse(
				savedUser.getId(),
				savedUser.getName(),
				savedUser.getEmail()
				);
	}
	
	public List<UserResponse> getAllUsers(){
		
		return userRepository.findAll()
				.stream()
				.map(user->new UserResponse(
						user.getId(),
						user.getName(),
						user.getEmail()
						))
				.toList();
				
	}
	
	public UserResponse getUserById(Long id) {
		
		User user = userRepository.findById(id)
				.orElseThrow(()->
				new UserNotFoundException(
						"User not found with id : "+id
						));
		
		return new UserResponse(
				user.getId(),
				user.getName(),
				user.getEmail()
				);
	}
	
	public UserResponse updateUser(Long id,UserRequest request) {
		
		User user = userRepository.findById(id)
				.orElseThrow(()->
				new UserNotFoundException(
						"User not found with id:"+id)
				);
		
		user.setName(request.getName());
		user.setEmail(request.getEmail());
		user.setPassword(request.getPassword());
		
		User userUpdate = userRepository.save(user);
	
		return new UserResponse(
				userUpdate.getId(),
				userUpdate.getName(),
				userUpdate.getEmail()
				);
	}
	
	public void deleteUser(Long id) {
		
		User user= userRepository.findById(id)
				.orElseThrow(()->
						new UserNotFoundException(
								"user not found by id:"+id
								));
		
		userRepository.delete(user);
	}
}
