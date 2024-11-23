package com.climate.decode.event.calculator.service;

import com.climate.decode.event.enums.CalculationType;

public interface MealEmissionCalcService {
	
	public void calculateEmission(String eventId, CalculationType calculationType);
	

}
