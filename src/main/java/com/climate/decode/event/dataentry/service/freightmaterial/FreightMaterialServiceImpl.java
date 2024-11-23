/**
 * 
 */
package com.climate.decode.event.dataentry.service.freightmaterial;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.climate.decode.event.dataentry.entity.freightmaterial.FreightMaterialDetails;
import com.climate.decode.event.exception.ResourceNotFoundException;
import com.climate.decode.event.dataentry.repository.material.FreightMaterialDetailsRepository;

import lombok.RequiredArgsConstructor;

/**
 * @author diwya
 *
 */

@RequiredArgsConstructor
@Service
public class FreightMaterialServiceImpl implements FreightMaterialService {

	private final FreightMaterialDetailsRepository repo;
	
	@Override
	public FreightMaterialDetails createFreightMaterialDetailsData(FreightMaterialDetails freightMaterialDetail) {
		return repo.save(freightMaterialDetail);
	}

	@Override
	public List<FreightMaterialDetails> getFreightMaterialDetailsDataByEventId(Integer eventId) {
		return repo.getByEventId(eventId);
	}

	@Override
	public Optional<FreightMaterialDetails> getFreightMaterialDetailsDataByEventIdAndFreightMaterialId(Integer eventId, Integer freightMaterialID) {
		return repo.getFreightMaterialDetailsDataByEventIdAndFreightMaterialId(eventId, freightMaterialID);
	}

	@Override
	public void deleteFreightMaterialDetailsData(Integer eventId, Integer freightMaterialId ) {
		if(repo.getFreightMaterialDetailsDataByEventIdAndFreightMaterialId(eventId, freightMaterialId).isPresent()) {
			repo.delete(repo.getFreightMaterialDetailsDataByEventIdAndFreightMaterialId(eventId, freightMaterialId).get());
		}else {
			throw new ResourceNotFoundException("Event not found with ID "+ eventId);
		}
	}

	@Override
	public FreightMaterialDetails updateFreightMaterialDetailsData(FreightMaterialDetails freightMaterialDetail) {
		if(repo.getFreightMaterialDetailsDataByEventIdAndFreightMaterialId(freightMaterialDetail.getEventId(), freightMaterialDetail.getFreightMaterialId()).isPresent()) {
			repo.save(freightMaterialDetail);
			return repo.getFreightMaterialDetailsDataByEventIdAndFreightMaterialId(freightMaterialDetail.getEventId(), freightMaterialDetail.getFreightMaterialId()).get();
		}else {
			throw new ResourceNotFoundException("Event not found with ID "+ freightMaterialDetail.getEventId());
		}
	}

}
