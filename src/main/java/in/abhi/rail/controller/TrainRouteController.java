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

import in.abhi.rail.DTO.TrainRouteRequest;
import in.abhi.rail.DTO.TrainRouteResponse;
import in.abhi.rail.service.TrainRouteService;

@RestController
@RequestMapping("/api/TrainRoutes")
public class TrainRouteController {
	
	private final TrainRouteService trainRouteService;
	
	public TrainRouteController(TrainRouteService trainRouteService) {
		this.trainRouteService=trainRouteService;
	}
	
	
	@PostMapping
	public TrainRouteResponse createTrainRoute(@RequestBody TrainRouteRequest request) {
		
		return trainRouteService.createTrainRoute(request);
	}
	
	@GetMapping
	public List<TrainRouteResponse> getAllTrainRoute() {
		
		return trainRouteService.getAllTrainRoutes();
	}
	
	@GetMapping("/{id}")
	public TrainRouteResponse getTrainRouteById(@PathVariable Long id) {
		
		return trainRouteService.getTrainRouteById(id);
	}
	
	@PutMapping("/{id}")
	public TrainRouteResponse updateTrainRoute(@PathVariable Long id,
			@RequestBody TrainRouteRequest request) {
		
		return trainRouteService.updateTrainRoute(id, request);
		
	}
	
	@DeleteMapping("/{id}")
	public void deleteTrainRoute(@PathVariable Long id) {
		
		trainRouteService.deleteTrainRoute(id);
	}

}
