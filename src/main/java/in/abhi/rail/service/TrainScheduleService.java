package in.abhi.rail.service;

import java.util.List;

import in.abhi.rail.DTO.TrainScheduleRequest;
import in.abhi.rail.DTO.TrainScheduleResponse;

public interface TrainScheduleService {
	
	TrainScheduleResponse createTrainSchedule(TrainScheduleRequest request);
	
	List<TrainScheduleResponse> getAllTrainSchedule();
	
	TrainScheduleResponse getTrainSchedule(Long id);
	
	TrainScheduleResponse updateTrainSchedule(Long id , TrainScheduleRequest request);
	
	void deleteTrainSchedule(Long id);

}
