package com.climate.decode.event.emissions.eventpreparation.controller;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RestController;

import com.climate.decode.event.emissions.eventpreparation.api.EventPreparationEmissionApi;
import com.climate.decode.event.emissions.eventpreparation.dto.EventPreparationEmissionDataDto;
import com.climate.decode.event.emissions.eventpreparation.facade.EventPreparationEmissionDataFacade;
import com.climate.decode.event.emissions.response.ApiResponse;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@CrossOrigin(origins = "*", allowedHeaders = "*")
@RequiredArgsConstructor
@RestController
@Slf4j
public class EventPreparationEmissionController implements EventPreparationEmissionApi {

	private final EventPreparationEmissionDataFacade eventPreparationEmissionFacade;
	
	@Override
	public ApiResponse<EventPreparationEmissionDataDto> createEventPreparationEmissionData(Integer eventPreparationId, EventPreparationEmissionDataDto eventPreparationEmissionDataDto) {
		log.info("EventPreparationEmissionController :: createEventPreparationEmissionData");
		return ApiResponse.ofSuccess(eventPreparationEmissionFacade.createEventPreparationEmissionData(eventPreparationId, eventPreparationEmissionDataDto),
				"Data save successfully");
	}

	@Override
	public ApiResponse<EventPreparationEmissionDataDto> getEventPreparationEmissionDataByEventPreparationId(Integer eventPreparationId) {
		log.info("EventPreparationEmissionController :: getEventPreparationEmissionDataByEventPreparationId");
		return ApiResponse.ofSuccess(eventPreparationEmissionFacade.getEventPreparationEmissionDataByEventPreparationId(eventPreparationId));
	}

	@Override
	public ApiResponse<String> deleteEventPreparationEmissionData(Integer eventPreparationId) {
		log.info("EventPreparationEmissionController :: deleteEventPreparationEmissionData");
		return ApiResponse.ofSuccess(eventPreparationEmissionFacade.deleteEventPreparationEmissionData(eventPreparationId));
	}

	@Override
	public ApiResponse<EventPreparationEmissionDataDto> updateEventPreparationEmissionData(Integer eventPreparationId, EventPreparationEmissionDataDto eventPreparationDetailsDto) {
		log.info("EventPreparationEmissionController :: updateEventPreparationEmissionData");
		return ApiResponse.ofSuccess(eventPreparationEmissionFacade.updateEventPreparationEmissionData(eventPreparationDetailsDto), "Data Successfully Updated");
	}

}
