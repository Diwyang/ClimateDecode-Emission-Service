package com.climate.decode.event.emissions.calculator.service;

import java.time.OffsetDateTime;
import java.util.List;

import org.springframework.stereotype.Service;

import com.climate.decode.event.emissions.accommodation.dto.AccommodationEmissionDataDto;
import com.climate.decode.event.emissions.accommodation.entity.AccommodationDetails;
import com.climate.decode.event.emissions.accommodation.facade.AccommodationEmissionDataFacade;
import com.climate.decode.event.emissions.accommodation.repository.AccommodationDetailsRepository;
import com.climate.decode.event.emissions.calculator.repository.EmissionFactorProjection;
import com.climate.decode.event.emissions.enums.CalculationType;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Service
@RequiredArgsConstructor
@Slf4j
public class AccomdationEmissionCalcServiceImpl implements AccomdationEmissionCalcService {

	private final AccommodationEmissionDataFacade accommodationEmissionFacade;
	private final AccommodationDetailsRepository accommodationDetailsRepository;
	private final GHGCalculationService ghgCalcService;
	
	@Override
	public void calculateEmission(String eventId, CalculationType calculationType, EmissionFactorProjection  efProject) {
		
		log.info("AccomdationEmissionCalcService ::  calculateEmission");
		
		boolean existingObj = true;
		AccommodationEmissionDataDto dto = null;
		List<AccommodationDetails> detailLst = accommodationDetailsRepository.getByEventId(Integer.getInteger(eventId));
		for (AccommodationDetails details : detailLst) {
			
			dto = accommodationEmissionFacade.getAccommodationEmissionDataByAccommodationId(details.getAccommodationId());
			if(dto == null) {
				existingObj = false;
				dto = new AccommodationEmissionDataDto();
				dto.setAccommodationId(details.getAccommodationId());
				dto.setCalculationType(calculationType);
				dto.setCreatedDateTime(OffsetDateTime.now());
			}
			
			dto = ghgCalcService.calculateAccommodationEmissions(details, efProject, dto);
			dto.setUpdatedDateTime(OffsetDateTime.now());
			
			log.info("AccomdationEmissionCalcService ::  calculateEmission after calculation dto >>>>  " + dto);
			if(existingObj) {
				dto = accommodationEmissionFacade.updateAccommodationEmissionData(dto);
			} else {
				dto = accommodationEmissionFacade.createAccommodationEmissionData(null, dto);
			}
			log.info("AccomdationEmissionCalcService ::  calculateEmission after saving dto >>>>  " + dto);
		}
	

	}

}
