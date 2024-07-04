package com.climate.decode.event.emissions.venue.service;

import java.util.Optional;

import org.springframework.stereotype.Service;

import com.climate.decode.event.emissions.exception.ResourceNotFoundException;
import com.climate.decode.event.emissions.venue.entity.VenueEmissionData;
import com.climate.decode.event.emissions.venue.repository.VenueEmissionDataRepository;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@RequiredArgsConstructor
@Service
@Slf4j
public class VenueEmissionDataServiceImpl implements VenueEmissionDataService {

	private final VenueEmissionDataRepository repo;
	
	@Override
	public VenueEmissionData createVenueEmissionData(VenueEmissionData venue) {
		log.info("VenueEmissionDataServiceImpl :: createVenueEmissionData");
		return repo.save(venue);
	}

	@Override
	public Optional<VenueEmissionData> getVenueEmissionDataByVenueId(Integer venueId) {
		log.info("VenueEmissionDataServiceImpl :: getVenueEmissionDataByVenueId");
		return repo.getByVenueId(venueId);
	}

	@Override
	public String deleteVenueEmissionData(Integer venueId) {
		log.info("VenueEmissionDataServiceImpl :: deleteVenueEmissionData");

		if (repo.getByVenueId(venueId).isPresent()) {
			repo.delete(repo.getByVenueId(venueId).get());
			return "Data Deleted Successfully";
		}
		throw new ResourceNotFoundException("Venue Emission not found with Venue ID " + venueId);

	}

	@Override
	public VenueEmissionData updateVenueEmissionData(VenueEmissionData venue) {
		log.info("VenueEmissionDataServiceImpl :: updateVenueEmissionData");

		if(repo.findById(Long.valueOf(""+venue.getId())).isPresent()) {
			repo.save(venue);
			return repo.getByVenueId(venue.getVenueId()).get();
		}else {
			throw new ResourceNotFoundException(String.format("Venue not found For Venue ID {}", venue.getVenueId()));
		}
	}

}
