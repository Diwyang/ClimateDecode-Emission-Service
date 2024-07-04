package com.climate.decode.event.emissions.travel.api;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import com.climate.decode.event.emissions.response.ApiResponse;
import com.climate.decode.event.emissions.travel.dto.TravelEmissionDataDto;


@RequestMapping("/emission/travels")
public interface TravelEmissionApi {

	@PostMapping("/{travelId}")
	public ApiResponse<TravelEmissionDataDto> createTravelEmissionData(@PathVariable(value = "travelId") Integer travelId, @RequestBody TravelEmissionDataDto travelDetailsDto);
	
	
	@GetMapping("/{travelId}")
	public ApiResponse<TravelEmissionDataDto> getTravelEmissionDataByTravelId(@PathVariable(value = "travelId") Integer travelId);

	
	@DeleteMapping("/{travelId}")
	public ApiResponse<String> deleteTravelEmissionData(@PathVariable(value = "travelId") Integer travelId);
	
	@PatchMapping("")
	public ApiResponse<TravelEmissionDataDto> updateTravelEmissionData(@PathVariable(value = "travelId") Integer travelId, @RequestBody TravelEmissionDataDto travelDetailsDto);
	
	
}
