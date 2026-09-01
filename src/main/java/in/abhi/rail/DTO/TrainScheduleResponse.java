package in.abhi.rail.DTO;

import java.time.LocalTime;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor

public class TrainScheduleResponse {
	
	private Long id;
	
	private Long trainId;
	
	private Long stationId;
	
	private LocalTime arrival;
	
	private LocalTime departure;
	
	private Integer stopSequence;
}
