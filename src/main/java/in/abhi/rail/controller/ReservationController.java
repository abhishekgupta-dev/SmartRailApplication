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

import in.abhi.rail.DTO.ReservationRequest;
import in.abhi.rail.DTO.ReservationResponse;
import in.abhi.rail.service.ReservationService;

@RestController
@RequestMapping("/api/reservations")
public class ReservationController {

	private final ReservationService reservationService;
	
	public ReservationController(ReservationService reservationService) {
		
		this.reservationService=reservationService;
	}
	
	@PostMapping
	public ReservationResponse createReservtion(@RequestBody ReservationRequest request) {
		
		return reservationService.createReservation(request);
	}
	
	@GetMapping
	public List<ReservationResponse> getAllReservation(){
		
		return reservationService.getAllReservation();
	}
	
	@GetMapping("/{id}")
	public ReservationResponse getReservationById(@PathVariable Long id) {
		
		return reservationService.getReservationById(id);
		
	}
	
	@PutMapping("/{id}")
	public ReservationResponse updateReservation(@PathVariable Long id,@RequestBody ReservationRequest request){
		
		return reservationService.updateReservation(id, request);
	}
	
	@DeleteMapping("/{id}")
	public void  deleteReservation(@PathVariable Long id ) {
		
		reservationService.deleteReservation(id);
	}
}
