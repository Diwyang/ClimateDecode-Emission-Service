package com.climate.decode.event.emissions.accommodation.service;

import java.util.Optional;

import org.springframework.stereotype.Service;

import com.climate.decode.event.emissions.exception.ResourceNotFoundException;
import com.climate.decode.event.emissions.accommodation.entity.AccommodationEmissionData;
import com.climate.decode.event.emissions.accommodation.repository.AccommodationEmissionDataRepository;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@RequiredArgsConstructor
@Service
@Slf4j
public class AccommodationEmissionDataServiceImpl implements AccommodationEmissionDataService {

	private final AccommodationEmissionDataRepository repo;
	
	@Override
	public AccommodationEmissionData createAccommodationEmissionData(AccommodationEmissionData accommodation) {
		log.info("AccommodationEmissionDataServiceImpl :: createAccommodationEmissionData");
		return repo.save(accommodation);
	}

	@Override
	public Optional<AccommodationEmissionData> getAccommodationEmissionDataByAccommodationId(Integer accommodationId) {
		log.info("AccommodationEmissionDataServiceImpl :: getAccommodationEmissionDataByAccommodationId");
		return repo.getByAccommodationId(accommodationId);
	}

	@Override
	public String deleteAccommodationEmissionData(Integer accommodationId) {
		log.info("AccommodationEmissionDataServiceImpl :: deleteAccommodationEmissionData");

		if (repo.getByAccommodationId(accommodationId).isPresent()) {
			repo.delete(repo.getByAccommodationId(accommodationId).get());
			return "Data Deleted Successfully";
		}
		throw new ResourceNotFoundException("Accommodation Emission not found with Accommodation ID " + accommodationId);

	}

	@Override
	public AccommodationEmissionData updateAccommodationEmissionData(AccommodationEmissionData accommodation) {
		log.info("AccommodationEmissionDataServiceImpl :: updateAccommodationEmissionData");

		if(repo.getByAccommodationId(accommodation.getAccommodationId()).isPresent()) {
			repo.save(accommodation);
			return repo.getByAccommodationId(accommodation.getAccommodationId()).get();
		}else {
			throw new ResourceNotFoundException(String.format("Accommodation not found For Accommodation ID {}", accommodation.getAccommodationId()));
		}
	}

}
