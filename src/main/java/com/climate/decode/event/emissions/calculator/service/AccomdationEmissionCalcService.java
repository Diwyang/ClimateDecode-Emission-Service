package com.climate.decode.event.emissions.calculator.service;

import com.climate.decode.event.emissions.calculator.repository.EmissionFactorProjection;
import com.climate.decode.event.emissions.enums.CalculationType;

public interface AccomdationEmissionCalcService {
	
	public void calculateEmission(String eventId, CalculationType calculationType, EmissionFactorProjection  efProject);
	

}
