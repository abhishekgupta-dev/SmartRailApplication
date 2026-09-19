package in.abhi.rail.service;

import java.util.List;

import org.springframework.stereotype.Service;

import in.abhi.rail.DTO.PaymentRequest;
import in.abhi.rail.DTO.PaymentResponse;
import in.abhi.rail.entity.Payment;
import in.abhi.rail.entity.Reservation;
import in.abhi.rail.exception.PaymentNotFoundException;
import in.abhi.rail.exception.ReservationNotFoundException;
import in.abhi.rail.repository.PaymentRepository;
import in.abhi.rail.repository.ReservationRepository;



@Service
public class PaymentServiceImpl implements PaymentService {
	
	private final PaymentRepository paymentRepository;
	
	private final ReservationRepository reservationRepository;
	public PaymentServiceImpl(PaymentRepository paymentRepository,ReservationRepository reservationRepository) {
		
		this.paymentRepository=paymentRepository;
		this.reservationRepository=reservationRepository;
	}
	
	@Override
	public PaymentResponse createPayment(PaymentRequest request) {
		
		Reservation reservation = reservationRepository.findById(request.getReservationId())
				.orElseThrow(()->
				new ReservationNotFoundException("Reservation not found "));
		
		Payment payment = new Payment();
		
		payment.setReservation(reservation);
		payment.setAmount(request.getAmount());
		payment.setPaymentMethod(request.getPaymentMethod());
		payment.setPaymentStatus("SUCCESS");
		payment.setTransactionId("TXN"+System.currentTimeMillis());
		
		Payment savedPayment = paymentRepository.save(payment);
		
		return toMapper(savedPayment);
	}
	
	//===========================All =========================================
	@Override
	public List<PaymentResponse> getAllPayment(){
		
		List<Payment> payment = paymentRepository.findAll();
		
		return payment
				.stream()
				.map(this::toMapper)
				.toList();
	}
	
	//=============================BY ID =======================================
	@Override
	public PaymentResponse getPaymentById(Long id ) {
		
		Payment payment = paymentRepository.findById(id)
				.orElseThrow(()->
				new PaymentNotFoundException("Payment not found by id : "+id)
						);
				
		return toMapper(payment);
	}
	
	//==============================UPDATE========================================
	@Override
	public PaymentResponse updatePayment(Long id , PaymentRequest request) {
		
		Payment payment = paymentRepository.findById(id)
				.orElseThrow(()->
				new PaymentNotFoundException("Payment not found")
				);
		
		Reservation reservation = reservationRepository.findById(request.getReservationId())
				.orElseThrow(()->
				new ReservationNotFoundException("Reservation not found"));
		
		payment.setReservation(reservation);
		payment.setAmount(request.getAmount());
		payment.setPaymentMethod(request.getPaymentMethod());
		
		Payment savedPayment = paymentRepository.save(payment);
		
		
		return toMapper(savedPayment);
	}
	
	
	//============================DELETE====================================
	@Override
	public void deletePayment(Long id) {
		
		Payment payment = paymentRepository.findById(id)
				.orElseThrow(()->
				new PaymentNotFoundException("Payment not found By id : "+id)
				);
		paymentRepository.delete(payment);
		
	}
	//======================TOMAPPER==============================================
	private PaymentResponse toMapper(Payment payment) {
		
		return new PaymentResponse(
				payment.getId(),
				payment.getReservation().getId(),
				payment.getAmount(),
				payment.getPaymentMethod(),
				payment.getPaymentStatus(),
				payment.getTransactionId()
				);
	}

}
