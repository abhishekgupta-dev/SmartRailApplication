package in.abhi.rail.payload;

import java.time.LocalDateTime;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class ApiResponse<T> {
	
	private Boolean succes;
	
	private LocalDateTime timeStamp;
	
	private int status;
	
	private String message;
	
	private T data;

}
