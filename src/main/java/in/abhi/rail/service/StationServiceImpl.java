package in.abhi.rail.service;

import java.util.List;

import org.springframework.stereotype.Service;

import in.abhi.rail.DTO.StationRequest;
import in.abhi.rail.DTO.StationResponse;
import in.abhi.rail.entity.Station;
import in.abhi.rail.exception.StationNotFoundException;
import in.abhi.rail.repository.StationRepository;


@Service
public class StationServiceImpl implements StationService {
	
	private final  StationRepository stationRepository;
	
	public StationServiceImpl(StationRepository stationRepository) {
		
		this.stationRepository=stationRepository;
	}
	
	public StationResponse createStation(StationRequest request) {
		
		Station station = new Station();
		
		station.setName(request.getName());
		station.setCode(request.getCode());
		station.setCity(request.getCity());
		station.setState(request.getState());
		
		Station savedStation= stationRepository.save(station);
		
		return toMapper(savedStation);
		
	}
	
	public List<StationResponse> getAllStation(){
		
		List<Station> stations = stationRepository.findAll();
		
		return stations.stream()
				.map(station->new StationResponse(
						station.getId(),
						station.getName(),
						station.getCode(),
						station.getCity(),
						station.getState()
						))
				.toList();
						
	}
	
	public StationResponse getStationById(Long id){
		
		Station station = stationRepository.findById(id).orElseThrow(()->
				new StationNotFoundException("Station Not Found by id  "+ id
						));
		
		return toMapper(station);
		
	}
	
	 public StationResponse updateStation(Long id,StationRequest request) {
		 
		 Station station = stationRepository.findById(id).orElseThrow(()->
		 		new StationNotFoundException("Station not found by id "+id
		 				));
		 
		 station.setName(request.getName());
		 station.setCode(request.getCode());
		 station.setCity(request.getCity());
		 station.setState(request.getState());
		 
		 return toMapper(stationRepository.save(station));
		 
		
	}
	 
	 public  void deleteStation(Long id) {
		 
		 Station station = stationRepository.findById(id)
				 .orElseThrow(()->
				 new StationNotFoundException(
						 "Station not found Exception by id "+id
						 ));
		 stationRepository.delete(station);
	 }
	 
	 
	 private StationResponse toMapper(Station station) {
		 
		return  new StationResponse(
					station.getId(),
					station.getName(),
					station.getCode(),
					station.getCity(),
					station.getState());
	 }
	 
	 
}
