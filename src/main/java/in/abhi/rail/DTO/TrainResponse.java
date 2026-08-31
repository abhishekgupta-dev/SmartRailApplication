package in.abhi.rail.DTO;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class TrainResponse {
	
	private Long id;
	
	private String trainNumaber;
	
	private String trainName;
	
	private String trainType;

}
