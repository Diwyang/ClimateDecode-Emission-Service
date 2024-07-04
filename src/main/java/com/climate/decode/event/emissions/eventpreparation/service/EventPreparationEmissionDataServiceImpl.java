package com.climate.decode.event.emissions.eventpreparation.service;

import java.util.Optional;

import org.springframework.stereotype.Service;

import com.climate.decode.event.emissions.exception.ResourceNotFoundException;
import com.climate.decode.event.emissions.eventpreparation.entity.EventPreparationEmissionData;
import com.climate.decode.event.emissions.eventpreparation.repository.EventPreparationEmissionDataRepository;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@RequiredArgsConstructor
@Service
@Slf4j
public class EventPreparationEmissionDataServiceImpl implements EventPreparationEmissionDataService {

	private final EventPreparationEmissionDataRepository repo;
	
	@Override
	public EventPreparationEmissionData createEventPreparationEmissionData(EventPreparationEmissionData eventPreparation) {
		log.info("EventPreparationEmissionDataServiceImpl :: createEventPreparationEmissionData");
		return repo.save(eventPreparation);
	}

	@Override
	public Optional<EventPreparationEmissionData> getEventPreparationEmissionDataByEventPreparationId(Integer eventPreparationId) {
		log.info("EventPreparationEmissionDataServiceImpl :: getEventPreparationEmissionDataByEventPreparationId");
		return repo.getByEventPreparationId(eventPreparationId);
	}

	@Override
	public String deleteEventPreparationEmissionData(Integer eventPreparationId) {
		log.info("EventPreparationEmissionDataServiceImpl :: deleteEventPreparationEmissionData");

		if (repo.getByEventPreparationId(eventPreparationId).isPresent()) {
			repo.delete(repo.getByEventPreparationId(eventPreparationId).get());
			return "Data Deleted Successfully";
		}
		throw new ResourceNotFoundException("EventPreparation Emission not found with EventPreparation ID " + eventPreparationId);

	}

	@Override
	public EventPreparationEmissionData updateEventPreparationEmissionData(EventPreparationEmissionData eventPreparation) {
		log.info("EventPreparationEmissionDataServiceImpl :: updateEventPreparationEmissionData");

		if(repo.getByEventPreparationId(eventPreparation.getEventPreparationId()).isPresent()) {
			repo.save(eventPreparation);
			return repo.getByEventPreparationId(eventPreparation.getEventPreparationId()).get();
		}else {
			throw new ResourceNotFoundException(String.format("EventPreparation not found For EventPreparation ID {}", eventPreparation.getEventPreparationId()));
		}
	}

}
