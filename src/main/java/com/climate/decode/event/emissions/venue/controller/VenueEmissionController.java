package com.climate.decode.event.emissions.venue.controller;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.climate.decode.event.emissions.venue.api.VenueEmissionApi;
import com.climate.decode.event.emissions.venue.dto.VenueEmissionDataDto;
import com.climate.decode.event.emissions.venue.facade.VenueEmissionDataFacade;
import com.climate.decode.event.emissions.response.ApiResponse;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@CrossOrigin(origins = "*", allowedHeaders = "*")
@RequiredArgsConstructor
@RestController
@Slf4j
public class VenueEmissionController implements VenueEmissionApi {

	private final VenueEmissionDataFacade venueEmissionFacade;
	
	@Override
	public ApiResponse<VenueEmissionDataDto> createVenueEmissionData(Integer venueId, VenueEmissionDataDto venueEmissionDataDto) {
		log.info("VenueEmissionController :: createVenueEmissionData");
		return ApiResponse.ofSuccess(venueEmissionFacade.createVenueEmissionData(venueId, venueEmissionDataDto),
				"Data save successfully");
	}

	@Override
	public ApiResponse<VenueEmissionDataDto> getVenueEmissionDataByVenueId(Integer venueId) {
		log.info("VenueEmissionController :: getVenueEmissionDataByVenueId");
		return ApiResponse.ofSuccess(venueEmissionFacade.getVenueEmissionDataByVenueId(venueId));
	}

	@Override
	public ApiResponse<String> deleteVenueEmissionData(Integer venueId) {
		log.info("VenueEmissionController :: deleteVenueEmissionData");
		return ApiResponse.ofSuccess(venueEmissionFacade.deleteVenueEmissionData(venueId));
	}

	@Override
	public ApiResponse<VenueEmissionDataDto> updateVenueEmissionData(VenueEmissionDataDto venueDetailsDto) {
		log.info("VenueEmissionController :: updateVenueEmissionData");
		return ApiResponse.ofSuccess(venueEmissionFacade.updateVenueEmissionData(venueDetailsDto), "Data Successfully Updated");
	}

}
