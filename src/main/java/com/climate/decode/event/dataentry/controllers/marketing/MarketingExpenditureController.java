/**
 * 
 */
package com.climate.decode.event.dataentry.controllers.marketing;

import java.util.List;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RestController;

import com.climate.decode.event.dataentry.api.marketing.MarketingExpenditureDetailsApi;
import com.climate.decode.event.dataentry.dto.marketing.MarketingExpenditureDetailsDto;
import com.climate.decode.event.dataentry.facade.marketing.MarketingExpenditureFacade;
import com.climate.decode.event.response.ApiResponse;

import lombok.RequiredArgsConstructor;

/**
 * @author diwya
 *
 */

@CrossOrigin(origins = "*", allowedHeaders = "*")
@RequiredArgsConstructor
@RestController
public class MarketingExpenditureController implements MarketingExpenditureDetailsApi {

	private final MarketingExpenditureFacade marketingExpenditureFacade;

	@Override
	public ApiResponse<MarketingExpenditureDetailsDto> createMarketingExpenditureDetails(Integer eventId, MarketingExpenditureDetailsDto marketingExpenditureDetailsDto) {
		return ApiResponse.ofSuccess(marketingExpenditureFacade.createMarketingExpenditureDetails(eventId, marketingExpenditureDetailsDto),
				"Data save successfully");
	}

	@Override
	public ApiResponse<List<MarketingExpenditureDetailsDto>> getMarketingExpenditureDetailsByEventId(Integer eventId) {
		return ApiResponse.ofSuccess(marketingExpenditureFacade.getMarketingExpenditureDetailsByEventId(eventId));
	}

	@Override
	public ApiResponse<String> deleteMarketingExpenditureDetails(Integer eventId, Integer marketingExpenditureId) {
		return ApiResponse.ofSuccess(marketingExpenditureFacade.deleteMarketingExpenditureDetails(eventId, marketingExpenditureId));
	}

	@Override
	public ApiResponse<MarketingExpenditureDetailsDto> updateMarketingExpenditureDetails(Integer eventId, MarketingExpenditureDetailsDto marketingExpenditureDetailsDto) {
		marketingExpenditureDetailsDto.setEventId(eventId);
		return ApiResponse.ofSuccess(marketingExpenditureFacade.updateMarketingExpenditureDetails(marketingExpenditureDetailsDto), "Data Successfully Updated");
	}

	@Override
	public ApiResponse<MarketingExpenditureDetailsDto> getMarketingExpenditureDetailsByMarketingExpenditureId(Integer eventId, Integer marketingExpenditureId) {
		return ApiResponse.ofSuccess(marketingExpenditureFacade.getMarketingExpenditureDetailsByEventIdAndMarketingExpenditureId(eventId, marketingExpenditureId));
	}

}
