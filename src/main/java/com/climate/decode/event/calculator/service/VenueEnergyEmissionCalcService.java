package com.climate.decode.event.calculator.service;

import com.climate.decode.event.enums.CalculationType;

public interface VenueEnergyEmissionCalcService {
	
	public void calculateEmission(String eventId, CalculationType calculationType);
	

}
