package in.abhi.rail.controller;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import in.abhi.rail.DTO.TrainRequest;
import in.abhi.rail.DTO.TrainResponse;
import in.abhi.rail.service.TrainService;
import jakarta.validation.Valid;

@RestController
@RequestMapping("api/tarins")
public class TrainController {
	
	private final TrainService trainService;
	
	public TrainController(TrainService trainService) {
		
		this.trainService=trainService;
	}
	
	@PostMapping
	public TrainResponse createTrain(@ Valid @RequestBody TrainRequest request ) {
		
		return trainService.createTrain(request);
	}
	
	@GetMapping
	public List<TrainResponse> getAllTrain(){
		
		return trainService.getAllTrain();
	}
	
	@GetMapping("/{id}")
	public TrainResponse getTrainById(@PathVariable Long id) {
		
		return trainService.getTrainById(id);
	}
	
	@PutMapping("/{id}")
	public TrainResponse updateTrain(@PathVariable Long id, @Valid @RequestBody TrainRequest request) {
		
		return trainService.updateTrain(id, request);
	}
	@DeleteMapping("/{id}")
	public void deleteTrain(@PathVariable Long id) {
		
		trainService.deleteTrain(id);
	}

}
