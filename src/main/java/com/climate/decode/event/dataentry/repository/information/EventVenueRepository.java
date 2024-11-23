package com.climate.decode.event.dataentry.repository.information;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.climate.decode.event.dataentry.entity.information.EventVenueDetails;

public interface EventVenueRepository extends JpaRepository<EventVenueDetails, Long> {

	List<EventVenueDetails> getByEventId(Integer eventId);

	Optional<EventVenueDetails> getByVenueId(Integer venueId);

	Optional<EventVenueDetails> getVenueDataByEventIdAndVenueId(Integer eventId, Integer venueId);
}
