package com.climate.decode.event.emissions.accommodation.api;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import com.climate.decode.event.emissions.accommodation.dto.AccommodationEmissionDataDto;
import com.climate.decode.event.emissions.response.ApiResponse;


@RequestMapping("/emission/accommodations")
public interface AccommodationEmissionApi {

	@PostMapping("/{accommodationId}")
	public ApiResponse<AccommodationEmissionDataDto> createAccommodationEmissionData(@PathVariable(value = "accommodationId") Integer accommodationId, @RequestBody AccommodationEmissionDataDto accommodationDetailsDto);
	
	
	@GetMapping("/{accommodationId}")
	public ApiResponse<AccommodationEmissionDataDto> getAccommodationEmissionDataByAccommodationId(@PathVariable(value = "accommodationId") Integer accommodationId);

	
	@DeleteMapping("/{accommodationId}")
	public ApiResponse<String> deleteAccommodationEmissionData(@PathVariable(value = "accommodationId") Integer accommodationId);
	
	@PatchMapping("")
	public ApiResponse<AccommodationEmissionDataDto> updateAccommodationEmissionData(@PathVariable(value = "accommodationId") Integer accommodationId, @RequestBody AccommodationEmissionDataDto accommodationDetailsDto);
	
	
}
