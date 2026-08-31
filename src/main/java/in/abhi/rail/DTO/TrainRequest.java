package in.abhi.rail.DTO;

import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class TrainRequest {
	
	@NotBlank(message="Train number should be required")
	private String trainNumber;
	
	@NotBlank(message="Train Name should be required")
	private String trainName;
	
	@NotBlank(message="Train Type should be required")
	private String trainType;
	
}
