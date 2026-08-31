package in.abhi.rail.exception;

import java.util.HashMap;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {
	
	@ExceptionHandler(MethodArgumentNotValidException.class)
	public Map<String,String> handleValidationException(MethodArgumentNotValidException ex){
		
		Map<String,String> errors= new HashMap<>();
	
		ex.getBindingResult()
		.getFieldErrors()
		.forEach(error->
		errors.put(
				error.getField(), 
				error.getDefaultMessage()
				)
		);
		return errors;
	}
	
	
	@ExceptionHandler(UserNotFoundException.class)
	public ResponseEntity<String> handleUserNotFound(
			UserNotFoundException ex){
		
		return ResponseEntity
				.status(HttpStatus.NOT_FOUND)
				.body(ex.getMessage());
	}
	
	@ExceptionHandler(StationNotFoundException.class)
	public ResponseEntity<String> handleStationNotFound(
			StationNotFoundException ex){
		
		return ResponseEntity
				.status(HttpStatus.NOT_FOUND)
				.body(ex.getMessage());
	}
	
	@ExceptionHandler(TrainNotFoundException.class)
	public ResponseEntity<String> handleTrainNotFound(
			TrainNotFoundException ex){
		
		return ResponseEntity
				.status(HttpStatus.NOT_FOUND)
				.body(ex.getMessage());
				
	}
	
	
	

}
