package in.abhi.rail.service;

import java.util.List;

import in.abhi.rail.DTO.ReservationRequest;
import in.abhi.rail.DTO.ReservationResponse;
import in.abhi.rail.entity.Reservation;

public interface ReservationService {

	ReservationResponse createReservation(ReservationRequest request);
	
	List<ReservationResponse> getAllReservation();
	
	ReservationResponse getReservationById(Long id);
	
	ReservationResponse updateReservation(Long id, ReservationRequest request);
	
	void deleteReservation(Long id);

	ReservationResponse cancelReservation(Long id);

}
