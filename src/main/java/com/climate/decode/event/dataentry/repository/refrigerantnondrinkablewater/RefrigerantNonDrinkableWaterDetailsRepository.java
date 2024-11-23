/**
 * 
 */
package com.climate.decode.event.dataentry.repository.refrigerantnondrinkablewater;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.climate.decode.event.dataentry.entity.refrigerantnondrinkablewater.RefrigerantNonDrinkableWaterDetails;

/**
 * @author diwya
 *
 */
public interface RefrigerantNonDrinkableWaterDetailsRepository extends JpaRepository<RefrigerantNonDrinkableWaterDetails, Long>  {

	List<RefrigerantNonDrinkableWaterDetails> getByEventId(Integer eventId);

	Optional<RefrigerantNonDrinkableWaterDetails> getByRefNonDrinkableId(Integer refrigerantNonDrinkableWaterId);

	Optional<RefrigerantNonDrinkableWaterDetails> getRefrigerantNonDrinkableWaterDataByEventIdAndRefNonDrinkableId(Integer eventId, Integer refrigerantNonDrinkableWaterId);
	
}
