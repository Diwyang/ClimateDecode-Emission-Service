/**
 * 
 */
package com.climate.decode.event.dataentry.repository.freightmaterial;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.climate.decode.event.dataentry.entity.material.MaterialDetails;

/**
 * @author diwya
 *
 */
public interface MaterialDetailsRepository extends JpaRepository<MaterialDetails, Long>  {

	List<MaterialDetails> getByEventId(Integer eventId);

	Optional<MaterialDetails> getByMaterialId(Integer materialId);

	Optional<MaterialDetails> getMaterialDetailsDataByEventIdAndMaterialId(Integer eventId, Integer materialId);
	
}
