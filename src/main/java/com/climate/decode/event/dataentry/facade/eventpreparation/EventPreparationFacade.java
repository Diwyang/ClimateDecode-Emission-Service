/**
 * 
 */
package com.climate.decode.event.dataentry.facade.eventpreparation;

import java.util.List;

import com.climate.decode.event.dataentry.dto.eventpreparation.EventPreparationDetailsDto;


/**
 * @author diwya
 *
 */
public interface EventPreparationFacade {

	public EventPreparationDetailsDto createEventPreparationDetails(Integer eventId, EventPreparationDetailsDto eventPreparationDetailsDto);

	public List<EventPreparationDetailsDto> getEventPreparationDetailsByEventId(Integer eventId);
	
	public EventPreparationDetailsDto getEventPreparationDetailsByEventIdAndEventPreparationId(Integer eventId, Integer eventPreparationId);

	public String deleteEventPreparationDetails(Integer eventId, Integer eventPreparationId);

	public EventPreparationDetailsDto updateEventPreparationDetails(EventPreparationDetailsDto eventPreparationDetailsDto);
}
