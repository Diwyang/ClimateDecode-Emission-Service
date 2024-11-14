package com.climate.decode.event.emissions.calculator.service;

import com.climate.decode.event.emissions.accommodation.dto.AccommodationEmissionDataDto;
import com.climate.decode.event.emissions.accommodation.entity.AccommodationDetails;
import com.climate.decode.event.emissions.calculator.repository.EmissionFactorProjection;

public interface GHGCalculationService {

	public AccommodationEmissionDataDto calculateAccommodationEmissions(AccommodationDetails details, EmissionFactorProjection emissionFactor, AccommodationEmissionDataDto dto);
}
