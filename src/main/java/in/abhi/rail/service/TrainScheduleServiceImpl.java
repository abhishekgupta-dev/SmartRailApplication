package in.abhi.rail.service;

import java.util.List;

import org.springframework.stereotype.Service;

import in.abhi.rail.DTO.TrainScheduleRequest;
import in.abhi.rail.DTO.TrainScheduleResponse;
import in.abhi.rail.entity.Station;
import in.abhi.rail.entity.Train;
import in.abhi.rail.entity.TrainSchedule;
import in.abhi.rail.exception.StationNotFoundException;
import in.abhi.rail.exception.TrainNotFoundException;
import in.abhi.rail.exception.TrainScheduleNotFoundException;
import in.abhi.rail.repository.StationRepository;
import in.abhi.rail.repository.TrainRepository;
import in.abhi.rail.repository.TrainScheduleRepository;

@Service
public class TrainScheduleServiceImpl  implements TrainScheduleService{
	
	
	private final TrainScheduleRepository trainScheduleRepository;
	
	private final TrainRepository trainRepository;
	
	private final StationRepository stationRepository;
	
	public TrainScheduleServiceImpl(TrainScheduleRepository trainScheduleRepository,TrainRepository trainRepository,StationRepository stationRepository) {
		
		this.trainScheduleRepository=trainScheduleRepository;
		this.trainRepository=trainRepository;
		this.stationRepository=stationRepository;
	}
	
	public TrainScheduleResponse createTrainSchedule(TrainScheduleRequest request) {
		
		Train train = trainRepository.findById(request.getTrainId())
				.orElseThrow(()->
				new TrainNotFoundException("Train not found"));
		
		Station station = stationRepository.findById(request.getStationId())
				.orElseThrow(()->
				new StationNotFoundException("Station not found"));
		
		 TrainSchedule trainSchedule = new  TrainSchedule();
		 
		 trainSchedule.setArrivalTime(request.getArrival());
		 
		 trainSchedule.setDepartureTime(request.getDeparture());
		 
		 trainSchedule.setTrain(train);
		 
		 trainSchedule.setStation(station);
		 
		 trainSchedule.setStopSequence(request.getStopSequence());
		 
		TrainSchedule savedTrainSchedule= trainScheduleRepository.save(trainSchedule);
		
		return toMapper(savedTrainSchedule); 
		 
	}
	
	public List<TrainScheduleResponse> getAllTrainSchedule(){
		
		List<TrainSchedule> schedules= trainScheduleRepository.findAll();
		
		return schedules
				.stream()
				.map(this::toMapper)
				.toList();
	}
	
	public TrainScheduleResponse getTrainScheduleById(Long id) {
		
		TrainSchedule  trainSchedule = trainScheduleRepository.findById(id)
				.orElseThrow(()->
				new TrainScheduleNotFoundException("Train Schedule Not found by id : "+id));
		
		return toMapper(trainSchedule);
	}
	
	public TrainScheduleResponse updateTrainSchedule(Long id, TrainScheduleRequest request) {
		

		TrainSchedule  trainSchedule = trainScheduleRepository.findById(id)
				.orElseThrow(()->
				new TrainScheduleNotFoundException("Train Schedule Not found by id : "+id));
		
		
		Train train = trainRepository.findById(request.getTrainId())
				.orElseThrow(()->
				new TrainNotFoundException("Train not found"));
		
		Station station = stationRepository.findById(request.getStationId())
				.orElseThrow(()->
				new StationNotFoundException("Station not found"));
		
		 
		 trainSchedule.setArrivalTime(request.getArrival());
		 
		 trainSchedule.setDepartureTime(request.getDeparture());
		 
		 trainSchedule.setTrain(train);
		 
		 trainSchedule.setStation(station);
		 
		 trainSchedule.setStopSequence(request.getStopSequence());
		 
		TrainSchedule savedTrainSchedule= trainScheduleRepository.save(trainSchedule);
		
		return toMapper(savedTrainSchedule); 
		
	}
	
	public void deleteTrainSchedule(Long id) {
		
		TrainSchedule  trainSchedule = trainScheduleRepository.findById(id)
				.orElseThrow(()->
				new TrainScheduleNotFoundException("Train Schedule Not found by id : "+id));
		
		
		trainScheduleRepository.delete(trainSchedule);
	}
	//====================================helper method===========================================
	
	
	private TrainScheduleResponse toMapper(TrainSchedule trainSchedule) {
		
		return new TrainScheduleResponse(
				trainSchedule.getId(),
				trainSchedule.getTrain().getId(),
				trainSchedule.getStation().getId(),
				trainSchedule.getArrivalTime(),
				trainSchedule.getDepartureTime(),
				trainSchedule.getStopSequence()
				);
	}

}
