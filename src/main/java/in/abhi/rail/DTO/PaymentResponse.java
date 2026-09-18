package in.abhi.rail.DTO;

import java.math.BigDecimal;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class PaymentResponse {

	private Long id;
	
	private Long  reservationId;
	
	private BigDecimal amount;
	
	private String PaymentMethod;
	
	private String Status;
	
	private String transactionId;
	
	
}
