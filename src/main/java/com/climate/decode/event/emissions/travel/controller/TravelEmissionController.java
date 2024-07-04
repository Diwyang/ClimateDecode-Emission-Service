package com.climate.decode.event.emissions.travel.controller;

import org.springframework.web.bind.annotation.RestController;

import com.climate.decode.event.emissions.travel.api.TravelEmissionApi;
import com.climate.decode.event.emissions.travel.dto.TravelEmissionDataDto;
import com.climate.decode.event.emissions.travel.facade.TravelEmissionDataFacade;
import com.climate.decode.event.emissions.response.ApiResponse;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@RequiredArgsConstructor
@RestController
@Slf4j
public class TravelEmissionController implements TravelEmissionApi {

	private final TravelEmissionDataFacade travelEmissionFacade;
	
	@Override
	public ApiResponse<TravelEmissionDataDto> createTravelEmissionData(Integer travelId, TravelEmissionDataDto travelEmissionDataDto) {
		log.info("TravelEmissionController :: createTravelEmissionData");
		return ApiResponse.ofSuccess(travelEmissionFacade.createTravelEmissionData(travelId, travelEmissionDataDto),
				"Data save successfully");
	}

	@Override
	public ApiResponse<TravelEmissionDataDto> getTravelEmissionDataByTravelId(Integer travelId) {
		log.info("TravelEmissionController :: getTravelEmissionDataByTravelId");
		return ApiResponse.ofSuccess(travelEmissionFacade.getTravelEmissionDataByTravelId(travelId));
	}

	@Override
	public ApiResponse<String> deleteTravelEmissionData(Integer travelId) {
		log.info("TravelEmissionController :: deleteTravelEmissionData");
		return ApiResponse.ofSuccess(travelEmissionFacade.deleteTravelEmissionData(travelId));
	}

	@Override
	public ApiResponse<TravelEmissionDataDto> updateTravelEmissionData(Integer travelId, TravelEmissionDataDto travelDetailsDto) {
		log.info("TravelEmissionController :: updateTravelEmissionData");
		return ApiResponse.ofSuccess(travelEmissionFacade.updateTravelEmissionData(travelDetailsDto), "Data Successfully Updated");
	}

}
