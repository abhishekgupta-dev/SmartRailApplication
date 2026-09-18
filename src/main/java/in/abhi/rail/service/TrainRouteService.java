package in.abhi.rail.service;

import java.util.List;

import in.abhi.rail.DTO.TrainRouteRequest;
import in.abhi.rail.DTO.TrainRouteResponse;

public interface TrainRouteService {

	TrainRouteResponse createTrainRoute(TrainRouteRequest request);

	List<TrainRouteResponse> getAllTrainRoutes();
	
	TrainRouteResponse getTrainRouteById(Long id);
	
	TrainRouteResponse updateTrainRoute(Long id, TrainRouteRequest request);
	
	void deleteTrainRoute(Long id);

}
