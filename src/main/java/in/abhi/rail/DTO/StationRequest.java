package in.abhi.rail.DTO;

import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class StationRequest {
	
	@NotBlank(message="Station name is required")
	private String name;
	
	@NotBlank(message="Station code is required")
	private String code;
	
	@NotBlank(message="City is required")
	private String city;
	
	@NotBlank(message="State is required")
	private String state;
	

}
