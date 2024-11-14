package com.climate.decode.event.emissions.calculator.api;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;

import com.climate.decode.event.emissions.calculator.model.EmissionFactor;
import com.climate.decode.event.emissions.enums.CalculationType;
import com.climate.decode.event.emissions.response.ApiResponse;

@RequestMapping("/emissions")
public interface RuleEngineApi {

	@PostMapping("/rule-engine/event/{eventId}")
	public ApiResponse<Object> runRuleEngine(@PathVariable String eventId, @RequestHeader(value = "x-calculation-type") CalculationType calculationType);

	@GetMapping("/emission-factor/{source}/country/{country}")
	public EmissionFactor getEmissionFactor(@PathVariable String source, @PathVariable String country);

}
