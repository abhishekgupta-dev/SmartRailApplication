package in.abhi.rail.DTO;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class StationResponse {

	private Long id ;
	
	private String name;
	
	private String code;
	
	private String city;
	
	private String state;
	
}
