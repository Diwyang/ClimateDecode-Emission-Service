/**
 * 
 */
package com.climate.decode.event.emissions.eventpreparation.facade;

import com.climate.decode.event.emissions.eventpreparation.dto.EventPreparationEmissionDataDto;

/**
 * @author diwya
 *
 */
public interface EventPreparationEmissionDataFacade {

	public EventPreparationEmissionDataDto createEventPreparationEmissionData(Integer eventPreparationId, EventPreparationEmissionDataDto eventPreparationEmissionDataDto);

	public EventPreparationEmissionDataDto getEventPreparationEmissionDataByEventPreparationId(Integer eventPreparationId);

	public String deleteEventPreparationEmissionData(Integer eventPreparationId);

	public EventPreparationEmissionDataDto updateEventPreparationEmissionData(EventPreparationEmissionDataDto eventPreparation);
}
