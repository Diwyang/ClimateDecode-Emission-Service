package com.climate.decode.event.emissions.venue.api;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import com.climate.decode.event.emissions.response.ApiResponse;
import com.climate.decode.event.emissions.venue.dto.VenueEmissionDataDto;


@RequestMapping("/emission/venues")
public interface VenueEmissionApi {

	@PostMapping("/{venueId}")
	public ApiResponse<VenueEmissionDataDto> createVenueEmissionData(@PathVariable(value = "venueId") Integer venueId, @RequestBody VenueEmissionDataDto venueDetailsDto);
	
	
	@GetMapping("/{venueId}")
	public ApiResponse<VenueEmissionDataDto> getVenueEmissionDataByVenueId(@PathVariable(value = "venueId") Integer venueId);

	
	@DeleteMapping("/{venueId}")
	public ApiResponse<String> deleteVenueEmissionData(@PathVariable(value = "venueId") Integer venueId);
	
	@PatchMapping("")
	public ApiResponse<VenueEmissionDataDto> updateVenueEmissionData(@RequestBody VenueEmissionDataDto venueDetailsDto);
	
	
}
