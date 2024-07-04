package com.climate.decode.event.emissions.accommodation.facade;

import java.time.OffsetDateTime;
import java.util.Optional;

import org.springframework.stereotype.Component;

import com.climate.decode.event.emissions.exception.ResourceNotFoundException;
import com.climate.decode.event.emissions.accommodation.converter.AccommodationEmissionConverter;
import com.climate.decode.event.emissions.accommodation.dto.AccommodationEmissionDataDto;
import com.climate.decode.event.emissions.accommodation.entity.AccommodationEmissionData;
import com.climate.decode.event.emissions.accommodation.service.AccommodationEmissionDataService;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;


@Component
@RequiredArgsConstructor
@Slf4j
public class AccommodationEmissionDataFacadeImpl implements AccommodationEmissionDataFacade {

	private final AccommodationEmissionConverter accommodationEmissionConverter;
	private final AccommodationEmissionDataService accommodationEmissionService;
	
	@Override
	public AccommodationEmissionDataDto createAccommodationEmissionData(Integer accommodationId, AccommodationEmissionDataDto accommodationEmissionDataDto) {
		log.info("AccommodationEmissionDataFacade :: createAccommodationEmissionData");
		AccommodationEmissionData accommodationEmission = accommodationEmissionConverter.toEntity(accommodationEmissionDataDto);
		accommodationEmission.setCreatedDateTime(OffsetDateTime.now());
		accommodationEmission.setUpdatedDateTime(OffsetDateTime.now());
		accommodationEmission = accommodationEmissionService.createAccommodationEmissionData(accommodationEmission);
		return accommodationEmissionConverter.toDto(accommodationEmission);
	}
	
	@Override
	public AccommodationEmissionDataDto getAccommodationEmissionDataByAccommodationId(Integer accommodationId) {
		log.info("AccommodationEmissionDataFacade :: getAccommodationEmissionDataByAccommodationId");
		Optional<AccommodationEmissionData> optAccommodationEmissionData = accommodationEmissionService.getAccommodationEmissionDataByAccommodationId(accommodationId);
		
		AccommodationEmissionData accommodationEmissionData = !optAccommodationEmissionData.isEmpty()? optAccommodationEmissionData.get(): null ;
		
		if (null == accommodationEmissionData) {
			throw new ResourceNotFoundException(String.format("Record Not Found with accommodationId {%x}", accommodationId));
		}
		
		return accommodationEmissionConverter.toDto(accommodationEmissionData);
	}
	
	@Override
	public String deleteAccommodationEmissionData(Integer accommodationId) {
		log.info("AccommodationEmissionDataFacade :: deleteAccommodationEmissionData");
		return accommodationEmissionService.deleteAccommodationEmissionData(accommodationId);
	}
	
	@Override
	public AccommodationEmissionDataDto updateAccommodationEmissionData(AccommodationEmissionDataDto accommodation) {
		log.info("AccommodationEmissionDataFacade :: updateAccommodationEmissionData");
		AccommodationEmissionData accommodationEmission = accommodationEmissionConverter.toEntity(accommodation);
		accommodationEmission.setUpdatedDateTime(OffsetDateTime.now());
		accommodationEmission = accommodationEmissionService.updateAccommodationEmissionData(accommodationEmission);
		return accommodationEmissionConverter.toDto(accommodationEmission);
	}
	
	

}
