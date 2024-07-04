package com.climate.decode.event.emissions.eventpreparation.facade;

import java.time.OffsetDateTime;
import java.util.Optional;

import org.springframework.stereotype.Component;

import com.climate.decode.event.emissions.exception.ResourceNotFoundException;
import com.climate.decode.event.emissions.eventpreparation.converter.EventPreparationEmissionConverter;
import com.climate.decode.event.emissions.eventpreparation.dto.EventPreparationEmissionDataDto;
import com.climate.decode.event.emissions.eventpreparation.entity.EventPreparationEmissionData;
import com.climate.decode.event.emissions.eventpreparation.service.EventPreparationEmissionDataService;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;


@Component
@RequiredArgsConstructor
@Slf4j
public class EventPreparationEmissionDataFacadeImpl implements EventPreparationEmissionDataFacade {

	private final EventPreparationEmissionConverter eventPreparationEmissionConverter;
	private final EventPreparationEmissionDataService eventPreparationEmissionService;
	
	@Override
	public EventPreparationEmissionDataDto createEventPreparationEmissionData(Integer eventPreparationId, EventPreparationEmissionDataDto eventPreparationEmissionDataDto) {
		log.info("EventPreparationEmissionDataFacade :: createEventPreparationEmissionData");
		EventPreparationEmissionData eventPreparationEmission = eventPreparationEmissionConverter.toEntity(eventPreparationEmissionDataDto);
		eventPreparationEmission.setCreatedDateTime(OffsetDateTime.now());
		eventPreparationEmission.setUpdatedDateTime(OffsetDateTime.now());
		eventPreparationEmission = eventPreparationEmissionService.createEventPreparationEmissionData(eventPreparationEmission);
		return eventPreparationEmissionConverter.toDto(eventPreparationEmission);
	}
	
	@Override
	public EventPreparationEmissionDataDto getEventPreparationEmissionDataByEventPreparationId(Integer eventPreparationId) {
		log.info("EventPreparationEmissionDataFacade :: getEventPreparationEmissionDataByEventPreparationId");
		Optional<EventPreparationEmissionData> optEventPreparationEmissionData = eventPreparationEmissionService.getEventPreparationEmissionDataByEventPreparationId(eventPreparationId);
		
		EventPreparationEmissionData eventPreparationEmissionData = !optEventPreparationEmissionData.isEmpty()? optEventPreparationEmissionData.get(): null ;
		
		if (null == eventPreparationEmissionData) {
			throw new ResourceNotFoundException(String.format("Record Not Found with eventPreparationId {%x}", eventPreparationId));
		}
		
		return eventPreparationEmissionConverter.toDto(eventPreparationEmissionData);
	}
	
	@Override
	public String deleteEventPreparationEmissionData(Integer eventPreparationId) {
		log.info("EventPreparationEmissionDataFacade :: deleteEventPreparationEmissionData");
		return eventPreparationEmissionService.deleteEventPreparationEmissionData(eventPreparationId);
	}
	
	@Override
	public EventPreparationEmissionDataDto updateEventPreparationEmissionData(EventPreparationEmissionDataDto eventPreparation) {
		log.info("EventPreparationEmissionDataFacade :: updateEventPreparationEmissionData");
		EventPreparationEmissionData eventPreparationEmission = eventPreparationEmissionConverter.toEntity(eventPreparation);
		eventPreparationEmission.setUpdatedDateTime(OffsetDateTime.now());
		eventPreparationEmission = eventPreparationEmissionService.updateEventPreparationEmissionData(eventPreparationEmission);
		return eventPreparationEmissionConverter.toDto(eventPreparationEmission);
	}
	
	

}
