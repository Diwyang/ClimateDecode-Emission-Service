/**
 * 
 */
package com.climate.decode.event.dataentry.controllers.transport;

import java.util.List;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RestController;

import com.climate.decode.event.dataentry.api.transport.TransportDetailsApi;
import com.climate.decode.event.dataentry.dto.transport.TransportDetailsDto;
import com.climate.decode.event.dataentry.facade.transport.TransportDetailsFacade;
import com.climate.decode.event.response.ApiResponse;

import lombok.RequiredArgsConstructor;

/**
 * @author diwya
 *
 */

@CrossOrigin(origins = "*", allowedHeaders = "*")
@RequiredArgsConstructor
@RestController
public class TransportDetailsController implements TransportDetailsApi {

	private final TransportDetailsFacade transportDetailsFacade; 
	@Override
	public ApiResponse<TransportDetailsDto> createTransportDetails(Integer eventId,
			TransportDetailsDto transportDetailsDto) {
		return ApiResponse.ofSuccess(transportDetailsFacade.createTransportDetails(eventId, transportDetailsDto),"Data save successfully");
	}

	@Override
	public ApiResponse<List<TransportDetailsDto>> getTransportDetailsByEventId(Integer eventId) {
		return ApiResponse.ofSuccess(transportDetailsFacade.getTransportDetailsByEventId(eventId));
	}

	@Override
	public ApiResponse<String> deleteTransportDetails(Integer eventId, Integer accommodationId) {
		return ApiResponse.ofSuccess(transportDetailsFacade.deleteTransportDetails(eventId, accommodationId));
	}

	@Override
	public ApiResponse<TransportDetailsDto> updateTransportDetails(Integer eventId,
			TransportDetailsDto transportDetailsDto) {
		transportDetailsDto.setEventId(eventId);
		return ApiResponse.ofSuccess(transportDetailsFacade.updateTransportDetails(transportDetailsDto),"Data Successfully Updated");
	}

	@Override
	public ApiResponse<TransportDetailsDto> getTransportDetailsByTransportId(Integer eventId,
			Integer transportId) {
		return ApiResponse.ofSuccess(transportDetailsFacade.getTransportDetailsByEventIdAndTransportId(eventId, transportId));
	}

}
