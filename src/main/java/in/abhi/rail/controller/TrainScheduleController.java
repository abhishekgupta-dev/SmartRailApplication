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

import in.abhi.rail.DTO.TrainScheduleRequest;
import in.abhi.rail.DTO.TrainScheduleResponse;
import in.abhi.rail.service.TrainScheduleService;

@RestController
@RequestMapping("/api/trainSchedules")
public class TrainScheduleController {
	
	private final TrainScheduleService trainScheduleService;
	
	public TrainScheduleController(TrainScheduleService trainScheduleService) {
		
		this.trainScheduleService=trainScheduleService;
	}
	
	@PostMapping
	public TrainScheduleResponse createTrainSchedule(@RequestBody TrainScheduleRequest traiScheduleRequet){
		
			return trainScheduleService.createTrainSchedule(traiScheduleRequet);
		
	}
	
	@GetMapping
	public List<TrainScheduleResponse> getAllTranSchedule() {
		
		return trainScheduleService.getAllTrainSchedule();
	}
	
	@GetMapping("/{id}")
	public TrainScheduleResponse getTrainScheduleById(@PathVariable Long id) {
		
		return trainScheduleService.getTrainScheduleById(id);
	}
	
	@PutMapping("/{id}")
	public TrainScheduleResponse updateTrainSchedule(@PathVariable Long id ,@RequestBody TrainScheduleRequest request) {
		
		return trainScheduleService.updateTrainSchedule(id, request); 
	}
	
	@DeleteMapping("/{id}")
	public void deleteTrainSchedule(@PathVariable Long id) {
		
		trainScheduleService.deleteTrainSchedule(id);
	}

}
