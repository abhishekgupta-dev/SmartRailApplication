package in.abhi.rail.DTO;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor

public class TrainRouteRequest {
	
	private Long trainId;
	
	private Long stationId;
	
	private Integer routeSequence;

}
