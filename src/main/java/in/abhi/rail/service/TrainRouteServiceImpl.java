package in.abhi.rail.service;

import java.util.List;

import org.springframework.stereotype.Service;

import in.abhi.rail.DTO.TrainRouteRequest;
import in.abhi.rail.DTO.TrainRouteResponse;
import in.abhi.rail.entity.Station;
import in.abhi.rail.entity.Train;
import in.abhi.rail.entity.TrainRoute;
import in.abhi.rail.exception.StationNotFoundException;
import in.abhi.rail.exception.TrainNotFoundException;
import in.abhi.rail.exception.TrainRouteNotFoundException;
import in.abhi.rail.repository.StationRepository;
import in.abhi.rail.repository.TrainRepository;
import in.abhi.rail.repository.TrainRouteRepository;

@Service
public class TrainRouteServiceImpl implements TrainRouteService{

	private final TrainRouteRepository trainRouteRepository;
	
	private final TrainRepository trainRepository;
	
	private final StationRepository stationRepository;
	
	public TrainRouteServiceImpl(TrainRouteRepository trainRouteRepository,
			TrainRepository trainRepository,
			StationRepository stationRepository) {
		
		this.trainRouteRepository=trainRouteRepository;
		this.trainRepository=trainRepository;
		this.stationRepository=stationRepository;
	}
	
	@Override
	 public TrainRouteResponse createTrainRoute(TrainRouteRequest request) {

	        Train train = trainRepository.findById(request.getTrainId())
	                .orElseThrow(() ->
	                        new TrainNotFoundException("Train not found"));

	        Station station = stationRepository.findById(request.getStationId())
	                .orElseThrow(() ->
	                        new StationNotFoundException("Station not found"));

	        TrainRoute trainRoute = new TrainRoute();

	        trainRoute.setTrain(train);
	        trainRoute.setStation(station);
	        trainRoute.setRouteSequence(request.getRouteSequence());

	        TrainRoute savedTrainRoute =
	                trainRouteRepository.save(trainRoute);

	        return toMapper(savedTrainRoute);
	    }
	 
	 @Override
	 public List<TrainRouteResponse> getAllTrainRoutes() {
		 List<TrainRoute>  trainRoutes = trainRouteRepository.findAll();
		 
		 return trainRoutes
				 .stream()
				 .map(this::toMapper)
				 .toList();
	 }
	 
	 @Override
	 public TrainRouteResponse getTrainRouteById(Long id) {
		 
		 TrainRoute  trainRoute = trainRouteRepository.findById(id).orElseThrow(()->
		 new TrainRouteNotFoundException(
				 "Train route not found by id : "+id));
		 
		 return toMapper(trainRoute);
	 }
	 
	 @Override
	 public TrainRouteResponse updateTrainRoute(Long id, TrainRouteRequest request){
		 
		 TrainRoute trainRoute = trainRouteRepository
				 .findById(id)
				 .orElseThrow(()->
		 new TrainRouteNotFoundException(
				 "Train Route Not Found by id : "+id
				 ));
		 
		 Train train = trainRepository.findById(request.getTrainId()).orElseThrow(()->
		 new TrainNotFoundException("Train Not Found"));
		 
		 Station station = stationRepository.findById(request.getStationId()).orElseThrow(()->
		 new StationNotFoundException("Station not found "));
		 
		 trainRoute.setTrain(train);
		 trainRoute.setStation(station);
		 trainRoute.setRouteSequence(request.getRouteSequence());
		 
		 TrainRoute updateTrainRoute = trainRouteRepository.save(trainRoute);
		 return toMapper(updateTrainRoute);
	 }
	 
	 @Override
	 public void deleteTrainRoute(Long id) {
		 
		 TrainRoute route = trainRouteRepository
				 .findById(id)
				 .orElseThrow(()->
		 new TrainRouteNotFoundException(
				 "Train Route not found by id : "+id
				 ));
		 trainRouteRepository.delete(route);
	 }

	    private TrainRouteResponse toMapper(TrainRoute trainRoute) {
	    	
	        return new TrainRouteResponse(
	                trainRoute.getId(),
	                trainRoute.getTrain().getId(),
	                trainRoute.getStation().getId(),
	                trainRoute.getRouteSequence()
	        );
	        
	       
	    }
}
