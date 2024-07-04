package com.climate.decode.event.emissions.dashboard.controller;

import java.util.List;

import org.springframework.web.bind.annotation.RestController;

import com.climate.decode.event.emissions.dashboard.api.EmissionsApi;
import com.climate.decode.event.emissions.dashboard.dto.EmissionDataDto;
import com.climate.decode.event.emissions.dashboard.facade.EmissionDataFacade;
import com.climate.decode.event.emissions.response.ApiResponse;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@RequiredArgsConstructor
@RestController
@Slf4j
public class EmissionsController implements EmissionsApi {

	private final EmissionDataFacade facade;
	

	@Override
	public ApiResponse<List<EmissionDataDto>> getCompleteDashboardByEventId(Integer eventId, String calculationType) {
		log.info("EmissionsController :: getCompleteDashboardByEventId");
		return ApiResponse.ofSuccess(facade.getEmissionDataByEventId(eventId, calculationType));
	}


	@Override
	public ApiResponse<List<EmissionDataDto>> getCompleteDashboardByOrganisationId(Integer orgId,
			String calculationType) {
		log.info("EmissionsController :: getCompleteDashboardByEventId");
		return ApiResponse.ofSuccess(facade.getEmissionDataByOrganisationId(orgId, calculationType));
	}

}
