package com.climate.decode.event.emissions.dashboard.api;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;

import com.climate.decode.event.emissions.dashboard.dto.EmissionDataDto;
import com.climate.decode.event.emissions.response.ApiResponse;


@RequestMapping("/emission/dashboard")
public interface EmissionsApi {

	@GetMapping("/{eventId}")
	public ApiResponse<List<EmissionDataDto>> getCompleteDashboardByEventId(@PathVariable(value = "eventId") Integer eventId, @RequestHeader(value ="calculationType", defaultValue = "PRE") String calculationType);
	
	@GetMapping("/organisation/{orgId}")
	public ApiResponse<List<EmissionDataDto>> getCompleteDashboardByOrganisationId(@PathVariable(value = "orgId") Integer orgId, @RequestHeader(value ="calculationType", defaultValue = "PRE") String calculationType);
	
}
