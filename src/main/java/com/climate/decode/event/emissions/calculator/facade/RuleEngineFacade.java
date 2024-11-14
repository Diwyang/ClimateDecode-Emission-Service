package com.climate.decode.event.emissions.calculator.facade;

import com.climate.decode.event.emissions.calculator.repository.EmissionFactorProjection;
import com.climate.decode.event.emissions.enums.CalculationType;
import com.climate.decode.event.emissions.response.ApiResponse;

public interface RuleEngineFacade {

	public ApiResponse<Object> runRuleEngine(String eventId, CalculationType calculationType);
	
	public EmissionFactorProjection getEmissionFactor(String source, String country);
	
}
