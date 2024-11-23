/**
 * 
 */
package com.climate.decode.event.dataentry.facade.marketing;

import java.util.List;

import com.climate.decode.event.dataentry.dto.marketing.MarketingExpenditureDetailsDto;


/**
 * @author diwya
 *
 */
public interface MarketingExpenditureFacade {

	public MarketingExpenditureDetailsDto createMarketingExpenditureDetails(Integer eventId, MarketingExpenditureDetailsDto marketingExpenditureDetailsDto);

	public List<MarketingExpenditureDetailsDto> getMarketingExpenditureDetailsByEventId(Integer eventId);
	
	public MarketingExpenditureDetailsDto getMarketingExpenditureDetailsByEventIdAndMarketingExpenditureId(Integer eventId, Integer marketingExpenditureId);

	public String deleteMarketingExpenditureDetails(Integer eventId, Integer marketingExpenditureId);

	public MarketingExpenditureDetailsDto updateMarketingExpenditureDetails(MarketingExpenditureDetailsDto marketingExpenditureDetailsDto);
}
