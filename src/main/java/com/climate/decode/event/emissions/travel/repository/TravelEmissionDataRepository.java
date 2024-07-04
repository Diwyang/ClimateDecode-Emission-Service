/**
 * 
 */
package com.climate.decode.event.emissions.travel.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.climate.decode.event.emissions.travel.entity.TravelEmissionData;

/**
 * @author diwya
 *
 */
public interface TravelEmissionDataRepository extends JpaRepository<TravelEmissionData, Long>  {

	Optional<TravelEmissionData> getByTravelId(Integer mealId);

}
