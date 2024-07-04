package com.climate.decode.event.emissions.travel.facade;

import java.time.OffsetDateTime;
import java.util.Optional;

import org.springframework.stereotype.Component;

import com.climate.decode.event.emissions.exception.ResourceNotFoundException;
import com.climate.decode.event.emissions.travel.converter.TravelEmissionConverter;
import com.climate.decode.event.emissions.travel.dto.TravelEmissionDataDto;
import com.climate.decode.event.emissions.travel.entity.TravelEmissionData;
import com.climate.decode.event.emissions.travel.service.TravelEmissionDataService;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;


@Component
@RequiredArgsConstructor
@Slf4j
public class TravelEmissionDataFacadeImpl implements TravelEmissionDataFacade {

	private final TravelEmissionConverter travelEmissionConverter;
	private final TravelEmissionDataService travelEmissionService;
	
	@Override
	public TravelEmissionDataDto createTravelEmissionData(Integer travelId, TravelEmissionDataDto travelEmissionDataDto) {
		log.info("TravelEmissionDataFacade :: createTravelEmissionData");
		TravelEmissionData travelEmission = travelEmissionConverter.toEntity(travelEmissionDataDto);
		travelEmission.setCreatedDateTime(OffsetDateTime.now());
		travelEmission.setUpdatedDateTime(OffsetDateTime.now());
		travelEmission = travelEmissionService.createTravelEmissionData(travelEmission);
		return travelEmissionConverter.toDto(travelEmission);
	}
	
	@Override
	public TravelEmissionDataDto getTravelEmissionDataByTravelId(Integer travelId) {
		log.info("TravelEmissionDataFacade :: getTravelEmissionDataByTravelId");
		Optional<TravelEmissionData> optTravelEmissionData = travelEmissionService.getTravelEmissionDataByTravelId(travelId);
		
		TravelEmissionData travelEmissionData = !optTravelEmissionData.isEmpty()? optTravelEmissionData.get(): null ;
		
		if (null == travelEmissionData) {
			throw new ResourceNotFoundException(String.format("Record Not Found with travelId {%x}", travelId));
		}
		
		return travelEmissionConverter.toDto(travelEmissionData);
	}
	
	@Override
	public String deleteTravelEmissionData(Integer travelId) {
		log.info("TravelEmissionDataFacade :: deleteTravelEmissionData");
		return travelEmissionService.deleteTravelEmissionData(travelId);
	}
	
	@Override
	public TravelEmissionDataDto updateTravelEmissionData(TravelEmissionDataDto travel) {
		log.info("TravelEmissionDataFacade :: updateTravelEmissionData");
		TravelEmissionData travelEmission = travelEmissionConverter.toEntity(travel);
		travelEmission.setUpdatedDateTime(OffsetDateTime.now());
		travelEmission = travelEmissionService.updateTravelEmissionData(travelEmission);
		return travelEmissionConverter.toDto(travelEmission);
	}
	
	

}
