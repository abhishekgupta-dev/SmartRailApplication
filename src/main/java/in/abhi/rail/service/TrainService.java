package in.abhi.rail.service;

import java.util.List;

import in.abhi.rail.DTO.TrainRequest;
import in.abhi.rail.DTO.TrainResponse;


public interface TrainService {
	
	TrainResponse createTrain(TrainRequest request);
	
	List<TrainResponse> getAllTrain();
	
	TrainResponse getTrainById(Long id);
	
	TrainResponse updateTrain(Long id,TrainRequest request);
	
	void deleteTrain(Long id);

}
