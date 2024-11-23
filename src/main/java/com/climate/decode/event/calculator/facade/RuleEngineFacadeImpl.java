package com.climate.decode.event.calculator.facade;

import java.util.Arrays;
import java.util.List;

import com.climate.decode.event.calculator.service.AccomdationEmissionCalcService;
import com.climate.decode.event.calculator.service.MealEmissionCalcService;
import com.climate.decode.event.emissions.response.ApiResponse;
import com.climate.decode.event.enums.CalculationType;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RequiredArgsConstructor
public class RuleEngineFacadeImpl implements RuleEngineFacade {

	private  List<String> list = Arrays.asList("Accomdation", "Meal");
	
	
	
	private final AccomdationEmissionCalcService accService;
	private final MealEmissionCalcService mealService;

	
	@Override
	public ApiResponse<Object> runRuleEngine(String eventId, CalculationType calculationType) {
		log.info("In RuleEngineFacade ::  runRuleEngine " + eventId);
		
		
		
		for(String source : list) {
			log.info("Source >>>   "+source);
			if(source.equalsIgnoreCase("Accomdation")){
				accService.calculateEmission(eventId, calculationType);
			} else if(source.equalsIgnoreCase("Meal")) {
				mealService.calculateEmission(eventId, calculationType);
			}
		}
		
		return ApiResponse.ofSuccess(null, "Rule Engine Execute Successfully..");
	}

//	@Override
//	public EmissionFactorProjection getEmissionFactor(String source, String country) {
//		log.info("In RuleEngineFacade ::  getEmissionFactor for  " + source + " and " + country);
//		return efService.getEmissionFactorBySource(source, country);
//	}

}
