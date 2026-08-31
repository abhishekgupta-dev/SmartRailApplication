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

import in.abhi.rail.DTO.StationRequest;
import in.abhi.rail.DTO.StationResponse;
import in.abhi.rail.service.StationService;

@RestController
@RequestMapping("api/stations")
public class StationController {
	
	private final StationService stationService;
	
	public StationController(StationService stationService) {
		
		this.stationService=stationService;
	}
	
	@PostMapping
	public StationResponse createStation(@RequestBody StationRequest request) {
		
		return stationService.createStation(request);
	}
	
	@GetMapping
	public List<StationResponse> getAllStation() {
		
		return stationService.getAllStation();
	}
	
	@GetMapping("/{id}")
	public StationResponse getStationById(@PathVariable Long id) {
		
		return stationService.getStationById(id);
	}
	
	@PutMapping("/{id}")
	public StationResponse updateStation(@PathVariable Long id,@RequestBody StationRequest request) {
		
		return stationService.updateStation(id, request);
	}
	
	@DeleteMapping("/{id}")
	public void deleteStation(@PathVariable Long id) {
		
		stationService.deleteStation(id);
		
	}

}
