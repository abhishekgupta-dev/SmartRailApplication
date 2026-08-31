package in.abhi.rail.service;

import java.util.List;

import org.springframework.stereotype.Service;

import in.abhi.rail.DTO.TrainRequest;
import in.abhi.rail.DTO.TrainResponse;
import in.abhi.rail.entity.Train;
import in.abhi.rail.exception.TrainNotFoundException;
import in.abhi.rail.repository.TrainRepository;

@Service
public class TrainServiceImpl implements TrainService {
	
	private final TrainRepository trainRepository;
	
	
	public TrainServiceImpl(TrainRepository trainRepository) {
		
		this.trainRepository=trainRepository;
	}
	

	public TrainResponse createTrain(TrainRequest request) {
		
		Train train = new Train();
		
		train.setTrainNumber(request.getTrainNumber());
		
		train.setTrainName(request.getTrainName());
		
		train.setTrainType(request.getTrainType());
		
		return toMapper(trainRepository.save(train));
	
	}
	
	public List<TrainResponse> getAllTrain(){
		
		List<Train> trains = trainRepository.findAll();
		
		return trains.stream()
				.map(train->
				new TrainResponse(
						train.getId(),
						train.getTrainNumber(),
						train.getTrainName(),
						train.getTrainType()
						))
				.toList();
		
		
	}
	
	
	public TrainResponse getTrainById(Long id ) {
		
		Train train = getTrainOrThrow(id);
		
		return toMapper(train);
	}
	
	
	public TrainResponse updateTrain(Long id , TrainRequest request) {
		
		Train train = getTrainOrThrow(id);
		
		train.setTrainNumber(request.getTrainNumber());
		train.setTrainName(request.getTrainName());
		train.setTrainType(request.getTrainType());
		
		
		return toMapper(trainRepository.save(train));
	}
	
	public void deleteTrain(Long id) {
		
		Train train = getTrainOrThrow(id);
		
		trainRepository.delete(train);
	}
	
	//============================== helper method  ==============================
	private TrainResponse toMapper(Train train) {
		
		return new TrainResponse(
				train.getId(),
				train.getTrainNumber(),
				train.getTrainName(),
				train.getTrainType());
	}
	
	private  Train getTrainOrThrow(Long id) {
		
		Train train = trainRepository.findById(id)
				.orElseThrow(()->
						new TrainNotFoundException("Train not Found by id  "+id)
				);
		
		return train;
	}
}
