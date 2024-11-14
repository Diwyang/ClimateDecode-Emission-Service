package com.climate.decode.event.emissions.calculator.facade;

import java.util.Arrays;
import java.util.List;

import com.climate.decode.event.emissions.calculator.repository.EmissionFactorProjection;
import com.climate.decode.event.emissions.calculator.service.AccomdationEmissionCalcService;
import com.climate.decode.event.emissions.calculator.service.EmissionFactorService;
import com.climate.decode.event.emissions.enums.CalculationType;
import com.climate.decode.event.emissions.information.dto.InformationDto;
import com.climate.decode.event.emissions.information.facade.InformationFacade;
import com.climate.decode.event.emissions.response.ApiResponse;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RequiredArgsConstructor
public class RuleEngineFacadeImpl implements RuleEngineFacade {

	private  List<String> list = Arrays.asList("Accomdation");
	
	private final EmissionFactorService efService;
	private final InformationFacade informationFacade;
	private final AccomdationEmissionCalcService accService;

	
	@Override
	public ApiResponse<Object> runRuleEngine(String eventId, CalculationType calculationType) {
		log.info("In RuleEngineFacade ::  runRuleEngine " + eventId);
		
		InformationDto infoDto = informationFacade.getInformationByEventId(Integer.getInteger(eventId));
		
		for(String source : list) {
			log.info("Source >>>   "+source);
			
			EmissionFactorProjection  efProject = efService.getEmissionFactorBySource(source, infoDto.getEventHostedCountry());
			
			if(source.equalsIgnoreCase("Accomdation")){
				accService.calculateEmission(eventId, calculationType, efProject);
			}
		}
		
		return ApiResponse.ofSuccess(null, "Rule Engine Execute Successfully..");
	}

	@Override
	public EmissionFactorProjection getEmissionFactor(String source, String country) {
		log.info("In RuleEngineFacade ::  getEmissionFactor for  " + source + " and " + country);
		return efService.getEmissionFactorBySource(source, country);
	}

}
