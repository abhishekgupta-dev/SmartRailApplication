package in.abhi.rail.DTO;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class ReservationResponse {

	private Long id;
	
	private Long userId;
	
	private Long trainScheduleId;
	
	private Integer seatNumber;
	
	private String status;
}
