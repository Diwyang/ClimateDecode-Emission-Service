package com.climate.decode.event.dataentry.service.refrigerantnondrinkablewater;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.climate.decode.event.dataentry.entity.refrigerantnondrinkablewater.RefrigerantNonDrinkableWaterDetails;
import com.climate.decode.event.exception.ResourceNotFoundException;
import com.climate.decode.event.dataentry.repository.refrigerantnondrinkablewater.RefrigerantNonDrinkableWaterDetailsRepository;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class RefrigerantNonDrinkableWaterServiceImpl implements RefrigerantNonDrinkableWaterService {


	private final RefrigerantNonDrinkableWaterDetailsRepository repo;
	
	@Override
	public RefrigerantNonDrinkableWaterDetails createRefrigerantNonDrinkableWaterData(RefrigerantNonDrinkableWaterDetails refrigerantNonDrinkableWater) {
		return repo.save(refrigerantNonDrinkableWater);
	}

	@Override
	public List<RefrigerantNonDrinkableWaterDetails> getRefrigerantNonDrinkableWaterDataByEventId(Integer eventId) {
		return repo.getByEventId(eventId);
	}

	@Override
	public Optional<RefrigerantNonDrinkableWaterDetails> getRefrigerantNonDrinkableWaterDataByEventId(Integer eventId, Integer refrigerantNonDrinkableWaterId) {
		return repo.getRefrigerantNonDrinkableWaterDataByEventIdAndRefNonDrinkableId(eventId, refrigerantNonDrinkableWaterId);
	}

	@Override
	public void deleteRefrigerantNonDrinkableWaterData(Integer eventId, Integer refrigerantNonDrinkableWaterId) {
		if(repo.getRefrigerantNonDrinkableWaterDataByEventIdAndRefNonDrinkableId(eventId, refrigerantNonDrinkableWaterId).isPresent()) {
			repo.delete(repo.getRefrigerantNonDrinkableWaterDataByEventIdAndRefNonDrinkableId(eventId, refrigerantNonDrinkableWaterId).get());
		}else {
			throw new ResourceNotFoundException("Event not found with ID "+ eventId);
		}

	}

	@Override
	public RefrigerantNonDrinkableWaterDetails updateRefrigerantNonDrinkableWaterData(RefrigerantNonDrinkableWaterDetails refrigerantNonDrinkableWater) {
		if(repo.getRefrigerantNonDrinkableWaterDataByEventIdAndRefNonDrinkableId(refrigerantNonDrinkableWater.getEventId(), refrigerantNonDrinkableWater.getRefNonDrinkableId()).isPresent()) {
			repo.save(refrigerantNonDrinkableWater);
			return repo.getRefrigerantNonDrinkableWaterDataByEventIdAndRefNonDrinkableId(refrigerantNonDrinkableWater.getEventId(), refrigerantNonDrinkableWater.getRefNonDrinkableId()).get();
		}else {
			throw new ResourceNotFoundException(String.format("RefrigerantNonDrinkableWater not found For Event ID  {} and RefrigerantNonDrinkableWater ID {}", refrigerantNonDrinkableWater.getEventId(),refrigerantNonDrinkableWater.getRefNonDrinkableId()));
		}
	}

}
