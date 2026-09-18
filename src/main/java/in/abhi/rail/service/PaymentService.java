package in.abhi.rail.service;

import java.util.List;

import in.abhi.rail.DTO.PaymentRequest;
import in.abhi.rail.DTO.PaymentResponse;

public interface PaymentService {

	
	PaymentResponse createPayment(PaymentRequest request);

	PaymentResponse getPaymentById(Long id );
	
	List<PaymentResponse> getAllPayment();
	
	PaymentResponse updatePayment(Long id , PaymentRequest request);
	
	void deletePayment(Long id);


}
