package com.climate.decode.event.emissions.travel.service;

import java.util.Optional;

import org.springframework.stereotype.Service;

import com.climate.decode.event.emissions.exception.ResourceNotFoundException;
import com.climate.decode.event.emissions.travel.entity.TravelEmissionData;
import com.climate.decode.event.emissions.travel.repository.TravelEmissionDataRepository;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@RequiredArgsConstructor
@Service
@Slf4j
public class TravelEmissionDataServiceImpl implements TravelEmissionDataService {

	private final TravelEmissionDataRepository repo;
	
	@Override
	public TravelEmissionData createTravelEmissionData(TravelEmissionData travel) {
		log.info("TravelEmissionDataServiceImpl :: createTravelEmissionData");
		return repo.save(travel);
	}

	@Override
	public Optional<TravelEmissionData> getTravelEmissionDataByTravelId(Integer travelId) {
		log.info("TravelEmissionDataServiceImpl :: getTravelEmissionDataByTravelId");
		return repo.getByTravelId(travelId);
	}

	@Override
	public String deleteTravelEmissionData(Integer travelId) {
		log.info("TravelEmissionDataServiceImpl :: deleteTravelEmissionData");

		if (repo.getByTravelId(travelId).isPresent()) {
			repo.delete(repo.getByTravelId(travelId).get());
			return "Data Deleted Successfully";
		}
		throw new ResourceNotFoundException("Travel Emission not found with Travel ID " + travelId);

	}

	@Override
	public TravelEmissionData updateTravelEmissionData(TravelEmissionData travel) {
		log.info("TravelEmissionDataServiceImpl :: updateTravelEmissionData");

		if(repo.getByTravelId(travel.getTravelId()).isPresent()) {
			repo.save(travel);
			return repo.getByTravelId(travel.getTravelId()).get();
		}else {
			throw new ResourceNotFoundException(String.format("Travel not found For Travel ID {}", travel.getTravelId()));
		}
	}

}
