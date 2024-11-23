/**
 * 
 */
package com.climate.decode.event.dataentry.service.eventpreparation;

import java.util.List;
import java.util.Optional;

import org.springframework.web.bind.annotation.RequestBody;

import com.climate.decode.event.dataentry.entity.eventpreparation.EventPreparationDetails;

/**
 * @author diwya
 *
 */
public interface EventPreparationService {

	public EventPreparationDetails createEventPreparationData(@RequestBody EventPreparationDetails eventPreparation);

	public List<EventPreparationDetails> getEventPreparationDataByEventId(Integer eventId);
	
	public Optional<EventPreparationDetails> getEventPreparationDataByEventId(Integer eventId, Integer eventPreparationId);

	public void deleteEventPreparationData(Integer eventId, Integer eventPreparationId);

	public EventPreparationDetails updateEventPreparationData(EventPreparationDetails eventPreparation);
}
