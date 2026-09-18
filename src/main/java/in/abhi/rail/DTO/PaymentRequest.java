package in.abhi.rail.DTO;

import java.math.BigDecimal;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;



@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class PaymentRequest {
	
	private Long reservationId;
	
	private BigDecimal amount;
	
	private String paymentMethod;

}
