package com.climate.decode.event.emissions.calculator.service;

import java.math.BigDecimal;

import com.climate.decode.event.emissions.accommodation.dto.AccommodationEmissionDataDto;
import com.climate.decode.event.emissions.accommodation.entity.AccommodationDetails;
import com.climate.decode.event.emissions.calculator.repository.EmissionFactorProjection;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RequiredArgsConstructor
public class GHGCalculationServiceImpl implements GHGCalculationService {
	
	@Override
	public AccommodationEmissionDataDto calculateAccommodationEmissions(AccommodationDetails details,
			EmissionFactorProjection emissionFactor, AccommodationEmissionDataDto dto) {
		log.info("GHGCalculationService :: calculateAccommodationEmissions ");
		log.info("details  "+details);
		log.info("emissionFactor  "+emissionFactor);
		log.info("dto  "+dto);
		
		Double eFactor = emissionFactor.getFactor();
		
		dto.setEmissionFactorUnit("tCO2");
		if (emissionFactor.getUnit().equalsIgnoreCase("kgCO2e/night")) {
			dto.setTotalEmission(BigDecimal.valueOf(details.getNoOfNight() * details.getNoOfPerson() * (eFactor/1000)));
		} else {
			dto.setTotalEmission(BigDecimal.valueOf(details.getNoOfNight() * details.getNoOfPerson() * eFactor));
		}
		return dto;
	}

	
	

}
