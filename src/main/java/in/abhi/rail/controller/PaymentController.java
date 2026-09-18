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

import in.abhi.rail.DTO.PaymentRequest;
import in.abhi.rail.DTO.PaymentResponse;
import in.abhi.rail.service.PaymentService;

@RestController
@RequestMapping("/api/payments")
public class PaymentController {
	
	private final PaymentService paymentService;
	
	public PaymentController(PaymentService paymentService) {
		
		this.paymentService=paymentService;
	}
	//=======================================================================
	@PostMapping
	public PaymentResponse createPayment(@RequestBody PaymentRequest request) {
		
		return paymentService.createPayment(request);
	}
	
	//======================================================================
	@GetMapping
	public List<PaymentResponse> getAllPayment(){
		
		return paymentService.getAllPayment();
	}
	
	//======================================================================
	@GetMapping("/{id}")
	public PaymentResponse getPaymentById(@PathVariable Long id) {
		
		return paymentService.getPaymentById(id);
	}
	
	//========================================================================
	@PutMapping("/{id}")
	public PaymentResponse updatePayment(@PathVariable Long id
			,@RequestBody PaymentRequest request) {
		
		return paymentService.updatePayment(id, request);
	}
	
	@DeleteMapping("/{id}")
	public void deletePayment(@PathVariable Long id) {
		
		paymentService.deletePayment(id);
	}

}
