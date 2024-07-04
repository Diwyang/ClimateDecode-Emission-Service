package com.climate.decode.event.emissions.eventpreparation.api;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import com.climate.decode.event.emissions.response.ApiResponse;
import com.climate.decode.event.emissions.eventpreparation.dto.EventPreparationEmissionDataDto;


@RequestMapping("/emission/event-preparations")
public interface EventPreparationEmissionApi {

	@PostMapping("/{eventPreparationId}")
	public ApiResponse<EventPreparationEmissionDataDto> createEventPreparationEmissionData(@PathVariable(value = "eventPreparationId") Integer eventPreparationId, @RequestBody EventPreparationEmissionDataDto eventPreparationDetailsDto);
	
	
	@GetMapping("/{eventPreparationId}")
	public ApiResponse<EventPreparationEmissionDataDto> getEventPreparationEmissionDataByEventPreparationId(@PathVariable(value = "eventPreparationId") Integer eventPreparationId);

	
	@DeleteMapping("/{eventPreparationId}")
	public ApiResponse<String> deleteEventPreparationEmissionData(@PathVariable(value = "eventPreparationId") Integer eventPreparationId);
	
	@PatchMapping("")
	public ApiResponse<EventPreparationEmissionDataDto> updateEventPreparationEmissionData(@PathVariable(value = "eventPreparationId") Integer eventPreparationId, @RequestBody EventPreparationEmissionDataDto eventPreparationDetailsDto);
	
	
}
