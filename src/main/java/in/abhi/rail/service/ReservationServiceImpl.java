package in.abhi.rail.service;

import java.util.List;

import org.springframework.stereotype.Service;

import in.abhi.rail.DTO.ReservationRequest;
import in.abhi.rail.DTO.ReservationResponse;
import in.abhi.rail.entity.Payment;
import in.abhi.rail.entity.Reservation;
import in.abhi.rail.entity.TrainSchedule;
import in.abhi.rail.entity.User;
import in.abhi.rail.exception.PaymentNotFoundException;
import in.abhi.rail.exception.ReservationNotFoundException;
import in.abhi.rail.exception.TrainScheduleNotFoundException;
import in.abhi.rail.exception.UserNotFoundException;
import in.abhi.rail.repository.PaymentRepository;
import in.abhi.rail.repository.ReservationRepository;
import in.abhi.rail.repository.TrainScheduleRepository;
import in.abhi.rail.repository.UserRepository;

@Service
public class ReservationServiceImpl implements ReservationService   {

	private final ReservationRepository reservationRepository;
	
	private final UserRepository userRepository;
	
	private final  TrainScheduleRepository trainScheduleRepository;

	private final PaymentRepository paymentRepository;

	public ReservationServiceImpl(
			ReservationRepository reservationRepository,
			UserRepository userRepository,
			
			TrainScheduleRepository trainScheduleRepository,
			PaymentRepository paymentRepository) {
		
		this.reservationRepository=reservationRepository;
		this.userRepository= userRepository;
		this.trainScheduleRepository = trainScheduleRepository;
		this.paymentRepository=paymentRepository;
	}

	//=====================================================
	@Override
 public ReservationResponse createReservation(ReservationRequest request) {
	 
	 User user = userRepository.findById(request.getUserId())
			.orElseThrow(()->
			new UserNotFoundException("User Not Found Exception"));
	 
	  TrainSchedule trainSchedule = trainScheduleRepository.findById(request.getTrainScheduleId())
			  .orElseThrow(()->
			  new  TrainScheduleNotFoundException("Train Schedule not found"));
	  
	  Reservation reservation = new Reservation();
	  
	  reservation.setUser(user);
	  
	  reservation.setTrainSchedule(trainSchedule);
	  
	  reservation.setSeatNumber(request.getSeatNumber());
	  
	 reservation.setStatus("CONFIRMED");
	 
	 Reservation savedReservation = reservationRepository.save(reservation);
	
	 return toMapper(savedReservation);
}
	//============================================================
	@Override
	public List<ReservationResponse> getAllReservation(){
		
		 List<Reservation> reservation = reservationRepository.findAll();
		 
		 return reservation.stream()
				 .map(this::toMapper)
				 .toList();
		
	}
	
	public ReservationResponse getReservationById(Long id) {
		
		Reservation reservation = reservationRepository.findById(id)
				.orElseThrow(()->
				new ReservationNotFoundException(
						" Reservation not found by id : "+id
						));
		
		return toMapper(reservation);
	}
	
	//=============================UPDATE===========================
	@Override
	public ReservationResponse updateReservation(Long id, ReservationRequest request) {
		
		
		Reservation reservation = reservationRepository.findById(id)
				.orElseThrow(()->
				new ReservationNotFoundException(
						" Reservation not found by id : "+id
						));
		
		User user = userRepository.findById(request.getUserId())
				.orElseThrow(()->
				new UserNotFoundException("User not found"));
		
		TrainSchedule schedule = trainScheduleRepository.findById(request.getTrainScheduleId())
				.orElseThrow(()->
				new TrainScheduleNotFoundException("Train Schedule not found "));
		
		reservation.setUser(user);
		
		reservation.setTrainSchedule(schedule);
		
		reservation.setSeatNumber(request.getSeatNumber());
		
		Reservation savedReservation = reservationRepository.save(reservation);
		
		return toMapper(savedReservation);
	}
	
	//============================DELETE=======================
	@Override
	public void deleteReservation(Long id) {
		
		Reservation reservation = reservationRepository.findById(id)
				
				.orElseThrow(()->
				new ReservationNotFoundException("Reservation not found by id : "+id));
		
		reservationRepository.delete(reservation);
				
	}
	//=======================================CANCLE======================
	@Override
	public ReservationResponse cancelReservation(Long id) {
		
		Reservation reservation = reservationRepository.findById(id)
				.orElseThrow(()->
				new ReservationNotFoundException(
						"Reservation not found "));
		
		reservation.setStatus("CANCELLED");
		
		Payment payment = paymentRepository
				.findByReservationId(id)
				.orElseThrow(()->
				new PaymentNotFoundException("Payment not found "));
		
		payment.setPaymentStatus("REFUNDED");
		
		paymentRepository.save(payment);
		
		Reservation savedReservation=reservationRepository.save(reservation);
		
		return toMapper(savedReservation);
	}
	
	//=============================MAPPER=================================
	private ReservationResponse toMapper(Reservation reservation) {
		
		return new ReservationResponse(
				reservation.getId(),
				reservation.getUser().getId(),
				reservation.getTrainSchedule().getId(),
				reservation.getSeatNumber(),
				reservation.getStatus());
		
		
	}
}
