package com.climate.decode.event.emissions.accommodation.controller;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RestController;

import com.climate.decode.event.emissions.accommodation.api.AccommodationEmissionApi;
import com.climate.decode.event.emissions.accommodation.dto.AccommodationEmissionDataDto;
import com.climate.decode.event.emissions.accommodation.facade.AccommodationEmissionDataFacade;
import com.climate.decode.event.emissions.response.ApiResponse;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@CrossOrigin(origins = "*", allowedHeaders = "*")
@RequiredArgsConstructor
@RestController
@Slf4j
public class AccommodationEmissionController implements AccommodationEmissionApi {

	private final AccommodationEmissionDataFacade accommodationEmissionFacade;
	
	@Override
	public ApiResponse<AccommodationEmissionDataDto> createAccommodationEmissionData(Integer accommodationId, AccommodationEmissionDataDto accommodationEmissionDataDto) {
		log.info("AccommodationEmissionController :: createAccommodationEmissionData");
		return ApiResponse.ofSuccess(accommodationEmissionFacade.createAccommodationEmissionData(accommodationId, accommodationEmissionDataDto),
				"Data save successfully");
	}

	@Override
	public ApiResponse<AccommodationEmissionDataDto> getAccommodationEmissionDataByAccommodationId(Integer accommodationId) {
		log.info("AccommodationEmissionController :: getAccommodationEmissionDataByAccommodationId");
		return ApiResponse.ofSuccess(accommodationEmissionFacade.getAccommodationEmissionDataByAccommodationId(accommodationId));
	}

	@Override
	public ApiResponse<String> deleteAccommodationEmissionData(Integer accommodationId) {
		log.info("AccommodationEmissionController :: deleteAccommodationEmissionData");
		return ApiResponse.ofSuccess(accommodationEmissionFacade.deleteAccommodationEmissionData(accommodationId));
	}

	@Override
	public ApiResponse<AccommodationEmissionDataDto> updateAccommodationEmissionData(Integer accommodationId, AccommodationEmissionDataDto accommodationDetailsDto) {
		log.info("AccommodationEmissionController :: updateAccommodationEmissionData");
		return ApiResponse.ofSuccess(accommodationEmissionFacade.updateAccommodationEmissionData(accommodationDetailsDto), "Data Successfully Updated");
	}

}
