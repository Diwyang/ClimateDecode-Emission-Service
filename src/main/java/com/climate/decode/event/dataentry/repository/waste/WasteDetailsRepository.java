/**
 * 
 */
package com.climate.decode.event.dataentry.repository.waste;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.climate.decode.event.dataentry.entity.waste.WasteDetails;

/**
 * @author diwya
 *
 */
public interface WasteDetailsRepository extends JpaRepository<WasteDetails, Long>  {

	List<WasteDetails> getByEventId(Integer eventId);

	Optional<WasteDetails> getByWasteId(Integer wasteId);

	Optional<WasteDetails> getWasteDataByEventIdAndWasteId(Integer eventId, Integer wasteId);
	
}
