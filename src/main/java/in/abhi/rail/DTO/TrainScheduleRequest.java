package in.abhi.rail.DTO;

import java.time.LocalTime;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class TrainScheduleRequest {
	
	private Long TrainId;
	
	private Long StationId;
	
	private LocalTime arrival;
	
	private LocalTime departure;
	
	private Integer stopSequence;

}
