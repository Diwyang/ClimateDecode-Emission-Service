package com.climate.decode.event.emissions.venue.facade;

import java.time.OffsetDateTime;
import java.util.Optional;

import org.springframework.stereotype.Component;

import com.climate.decode.event.emissions.exception.ResourceNotFoundException;
import com.climate.decode.event.emissions.venue.converter.VenueEmissionConverter;
import com.climate.decode.event.emissions.venue.dto.VenueEmissionDataDto;
import com.climate.decode.event.emissions.venue.entity.VenueEmissionData;
import com.climate.decode.event.emissions.venue.service.VenueEmissionDataService;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;


@Component
@RequiredArgsConstructor
@Slf4j
public class VenueEmissionDataFacadeImpl implements VenueEmissionDataFacade {

	private final VenueEmissionConverter venueEmissionConverter;
	private final VenueEmissionDataService venueEmissionService;
	
	@Override
	public VenueEmissionDataDto createVenueEmissionData(Integer venueId, VenueEmissionDataDto venueEmissionDataDto) {
		log.info("VenueEmissionDataFacade :: createVenueEmissionData");
		VenueEmissionData venueEmission = venueEmissionConverter.toEntity(venueEmissionDataDto);
		venueEmission.setCreatedDateTime(OffsetDateTime.now());
		venueEmission.setUpdatedDateTime(OffsetDateTime.now());
		venueEmission = venueEmissionService.createVenueEmissionData(venueEmission);
		return venueEmissionConverter.toDto(venueEmission);
	}
	
	@Override
	public VenueEmissionDataDto getVenueEmissionDataByVenueId(Integer venueId) {
		log.info("VenueEmissionDataFacade :: getVenueEmissionDataByVenueId");
		Optional<VenueEmissionData> optVenueEmissionData = venueEmissionService.getVenueEmissionDataByVenueId(venueId);
		
		VenueEmissionData venueEmissionData = !optVenueEmissionData.isEmpty()? optVenueEmissionData.get(): null ;
		
		if (null == venueEmissionData) {
			throw new ResourceNotFoundException(String.format("Record Not Found with venueId {%x}", venueId));
		}
		
		return venueEmissionConverter.toDto(venueEmissionData);
	}
	
	@Override
	public String deleteVenueEmissionData(Integer venueId) {
		log.info("VenueEmissionDataFacade :: deleteVenueEmissionData");
		return venueEmissionService.deleteVenueEmissionData(venueId);
	}
	
	@Override
	public VenueEmissionDataDto updateVenueEmissionData(VenueEmissionDataDto venue) {
		log.info("VenueEmissionDataFacade :: updateVenueEmissionData");
		VenueEmissionData venueEmission = venueEmissionConverter.toEntity(venue);
		venueEmission.setUpdatedDateTime(OffsetDateTime.now());
		venueEmission = venueEmissionService.updateVenueEmissionData(venueEmission);
		return venueEmissionConverter.toDto(venueEmission);
	}
	
	

}
