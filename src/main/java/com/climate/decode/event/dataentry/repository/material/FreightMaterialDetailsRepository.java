/**
 * 
 */
package com.climate.decode.event.dataentry.repository.material;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.climate.decode.event.dataentry.entity.freightmaterial.FreightMaterialDetails;

/**
 * @author diwya
 *
 */
public interface FreightMaterialDetailsRepository extends JpaRepository<FreightMaterialDetails, Long>  {

	List<FreightMaterialDetails> getByEventId(Integer eventId);

	Optional<FreightMaterialDetails> getByFreightMaterialId(Integer freightMaterialId);

	Optional<FreightMaterialDetails> getFreightMaterialDetailsDataByEventIdAndFreightMaterialId(Integer eventId, Integer freightMaterialId);
	
}
