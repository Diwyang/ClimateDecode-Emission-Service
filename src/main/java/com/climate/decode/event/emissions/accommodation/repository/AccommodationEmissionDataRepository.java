/**
 * 
 */
package com.climate.decode.event.emissions.accommodation.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.climate.decode.event.emissions.accommodation.entity.AccommodationEmissionData;

/**
 * @author diwya
 *
 */
public interface AccommodationEmissionDataRepository extends JpaRepository<AccommodationEmissionData, Long>  {

	Optional<AccommodationEmissionData> getByAccommodationId(Integer accommodationId);

}
