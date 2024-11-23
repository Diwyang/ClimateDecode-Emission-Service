/**
 * 
 */
package com.climate.decode.event.dataentry.controllers.eventpreparation;

import java.util.List;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RestController;

import com.climate.decode.event.dataentry.api.eventpreparation.EventPreparationDetailsApi;
import com.climate.decode.event.dataentry.dto.eventpreparation.EventPreparationDetailsDto;
import com.climate.decode.event.dataentry.facade.eventpreparation.EventPreparationFacade;
import com.climate.decode.event.response.ApiResponse;

import lombok.RequiredArgsConstructor;

/**
 * @author diwya
 *
 */

@CrossOrigin(origins = "*", allowedHeaders = "*")
@RequiredArgsConstructor
@RestController
public class EventPreparationController implements EventPreparationDetailsApi {

	private final EventPreparationFacade eventPreparationFacade;

	@Override
	public ApiResponse<EventPreparationDetailsDto> createEventPreparationDetails(Integer eventId, EventPreparationDetailsDto eventPreparationDetailsDto) {
		return ApiResponse.ofSuccess(eventPreparationFacade.createEventPreparationDetails(eventId, eventPreparationDetailsDto),
				"Data save successfully");
	}

	@Override
	public ApiResponse<List<EventPreparationDetailsDto>> getEventPreparationDetailsByEventId(Integer eventId) {
		return ApiResponse.ofSuccess(eventPreparationFacade.getEventPreparationDetailsByEventId(eventId));
	}

	@Override
	public ApiResponse<String> deleteEventPreparationDetails(Integer eventId, Integer eventPreparationId) {
		return ApiResponse.ofSuccess(eventPreparationFacade.deleteEventPreparationDetails(eventId, eventPreparationId));
	}

	@Override
	public ApiResponse<EventPreparationDetailsDto> updateEventPreparationDetails(Integer eventId, EventPreparationDetailsDto eventPreparationDetailsDto) {
		eventPreparationDetailsDto.setEventId(eventId);
		return ApiResponse.ofSuccess(eventPreparationFacade.updateEventPreparationDetails(eventPreparationDetailsDto), "Data Successfully Updated");
	}

	@Override
	public ApiResponse<EventPreparationDetailsDto> getEventPreparationDetailsByEventPreparationId(Integer eventId, Integer eventPreparationId) {
		return ApiResponse.ofSuccess(eventPreparationFacade.getEventPreparationDetailsByEventIdAndEventPreparationId(eventId, eventPreparationId));
	}

}
