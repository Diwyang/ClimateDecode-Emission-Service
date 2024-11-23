/**
 * 
 */
package com.climate.decode.event.dataentry.repository.venue;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.climate.decode.event.dataentry.entity.venue.VenueDetails;

/**
 * @author diwya
 *
 */
public interface VenueDetailsRepository extends JpaRepository<VenueDetails, Long>  {

	List<VenueDetails> getByEventId(Integer eventId);

	Optional<VenueDetails> getByVenueId(Integer venueId);

	Optional<VenueDetails> getVenueDataByEventIdAndVenueId(Integer eventId, Integer venueId);
	
}
