package com.climate.decode.event.emissions.calculator.controllers;

import com.climate.decode.event.emissions.calculator.api.RuleEngineApi;
import com.climate.decode.event.emissions.calculator.facade.RuleEngineFacade;
import com.climate.decode.event.emissions.calculator.model.EmissionFactor;
import com.climate.decode.event.emissions.enums.CalculationType;
import com.climate.decode.event.emissions.response.ApiResponse;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RequiredArgsConstructor
public class RuleEnginecontroller implements RuleEngineApi {

	private final RuleEngineFacade facade;
	
	@Override
	public ApiResponse<Object> runRuleEngine(String eventId, CalculationType calculationType) {
		log.info("RuleEnginecontroller ::: calling runRuleEngine for eventId "+eventId);
		
		return facade.runRuleEngine(eventId, calculationType);
	}

	@Override
	public EmissionFactor getEmissionFactor(String source, String country) {
		// TODO Auto-generated method stub
		return null;
	}

}
