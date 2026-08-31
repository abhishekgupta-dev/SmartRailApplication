package in.abhi.rail.service;

import java.util.List;

import in.abhi.rail.DTO.StationRequest;
import in.abhi.rail.DTO.StationResponse;


public interface StationService {
	
	StationResponse createStation(StationRequest request);
	
	List<StationResponse> getAllStation();
	
	StationResponse getStationById(Long id);
	
	StationResponse updateStation(Long id,StationRequest request);
	
	void deleteStation(Long id);

}


