/**
 * 
 */
package com.climate.decode.event.dataentry.repository.marketing;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.climate.decode.event.dataentry.entity.marketing.MarketingExpenditureDetails;

/**
 * @author diwya
 *
 */
public interface MarketingExpenditureDetailsRepository extends JpaRepository<MarketingExpenditureDetails, Long>  {

	List<MarketingExpenditureDetails> getByEventId(Integer eventId);

	Optional<MarketingExpenditureDetails> getByMarketingId(Integer marketingId);

	Optional<MarketingExpenditureDetails> getMarketingExpenditureDataByEventIdAndMarketingId(Integer eventId, Integer marketingId);
	
}
