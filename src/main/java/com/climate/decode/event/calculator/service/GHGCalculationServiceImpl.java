package com.climate.decode.event.calculator.service;

import java.math.BigDecimal;

import com.climate.decode.event.calculator.repository.EmissionFactorProjection;
import com.climate.decode.event.dataentry.entity.accommodation.AccommodationDetails;
import com.climate.decode.event.dataentry.entity.meal.MealDetails;
import com.climate.decode.event.dataentry.entity.venue.VenueDetails;
import com.climate.decode.event.emissions.accommodation.dto.AccommodationEmissionDataDto;
import com.climate.decode.event.emissions.meal.dto.MealEmissionDataDto;
import com.climate.decode.event.emissions.venue.dto.VenueEmissionDataDto;

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

	@Override
	public MealEmissionDataDto calculateMealEmissions(MealDetails details, EmissionFactorProjection emissionFactor,
			MealEmissionDataDto dto) {
		log.info("GHGCalculationService :: calculateMealEmissions details  " + details);
		log.info("emissionFactor  " + emissionFactor);
		log.info("dto  " + dto);

		Double eFactor = emissionFactor.getFactor();
		dto.setEmissionFactorUnit("tCO2");

		if (details.getNoOfMealServed() > -1) {
				dto.setTotalEmission(BigDecimal.valueOf(details.getNoOfMealServed() * eFactor));
		} else if (details.getNoOfFoodTruck() > -1) {
				dto.setTotalEmission(BigDecimal.valueOf(details.getNoOfFoodTruck() * eFactor));
		} else if (details.getPerVegMealWithFoodTruck() != null) {
				dto.setTotalEmission(details.getPerVegMealWithFoodTruck().multiply(BigDecimal.valueOf(eFactor)));
		} else if (details.getPerVegMealNoFoodTruck() != null) {
				dto.setTotalEmission(details.getPerVegMealWithFoodTruck().multiply(BigDecimal.valueOf(eFactor)));
		}
		
		if (emissionFactor.getUnit().equalsIgnoreCase("kgCO2e/unit")) {
			dto.setTotalEmission(dto.getTotalEmission().divide(BigDecimal.valueOf(1000)));
		}

		return dto;
	}

	@Override
	public VenueEmissionDataDto calculateVenueEmissions(VenueDetails details, EmissionFactorProjection emissionFactor,
			VenueEmissionDataDto dto) {
		log.info("GHGCalculationService :: calculateMealEmissions details  " + details);
		log.info("emissionFactor  " + emissionFactor);
		log.info("dto  " + dto);
		
		
		return dto;
	}
	

}
