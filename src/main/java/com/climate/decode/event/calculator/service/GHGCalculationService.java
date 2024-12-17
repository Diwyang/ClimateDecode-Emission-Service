package com.climate.decode.event.calculator.service;

import com.climate.decode.event.dataentry.entity.accommodation.AccommodationDetails;
import com.climate.decode.event.dataentry.entity.meal.MealDetails;
import com.climate.decode.event.dataentry.entity.venue.VenueDetails;
import com.climate.decode.event.emissions.accommodation.dto.AccommodationEmissionDataDto;
import com.climate.decode.event.calculator.repository.EmissionFactorProjection;
import com.climate.decode.event.emissions.meal.dto.MealEmissionDataDto;
import com.climate.decode.event.emissions.venue.dto.VenueEmissionDataDto;

public interface GHGCalculationService {

	public AccommodationEmissionDataDto calculateAccommodationEmissions(AccommodationDetails details, EmissionFactorProjection emissionFactor, AccommodationEmissionDataDto dto);
	
	public MealEmissionDataDto calculateMealEmissions(MealDetails details, EmissionFactorProjection emissionFactor, MealEmissionDataDto dto);

	public VenueEmissionDataDto calculateVenueEmissions(VenueDetails details, EmissionFactorProjection emissionFactor,
			VenueEmissionDataDto dto);
}
