/**
 * 
 */
package com.climate.decode.event.emissions.eventpreparation.service;

import java.util.Optional;

import com.climate.decode.event.emissions.eventpreparation.entity.EventPreparationEmissionData;

/**
 * @author diwya
 *
 */
public interface EventPreparationEmissionDataService {

	public EventPreparationEmissionData createEventPreparationEmissionData(EventPreparationEmissionData eventPreparation);

	public Optional<EventPreparationEmissionData> getEventPreparationEmissionDataByEventPreparationId(Integer eventPreparationId);

	public String deleteEventPreparationEmissionData(Integer eventPreparationId);

	public EventPreparationEmissionData updateEventPreparationEmissionData(EventPreparationEmissionData meal);
}
