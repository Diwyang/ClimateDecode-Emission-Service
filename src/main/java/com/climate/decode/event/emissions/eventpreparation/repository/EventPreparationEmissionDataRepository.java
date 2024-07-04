/**
 * 
 */
package com.climate.decode.event.emissions.eventpreparation.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.climate.decode.event.emissions.eventpreparation.entity.EventPreparationEmissionData;

/**
 * @author diwya
 *
 */
public interface EventPreparationEmissionDataRepository extends JpaRepository<EventPreparationEmissionData, Long>  {

	Optional<EventPreparationEmissionData> getByEventPreparationId(Integer mealId);

}
