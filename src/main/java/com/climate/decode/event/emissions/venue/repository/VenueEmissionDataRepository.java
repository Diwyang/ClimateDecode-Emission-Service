/**
 * 
 */
package com.climate.decode.event.emissions.venue.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.climate.decode.event.emissions.venue.entity.VenueEmissionData;

/**
 * @author diwya
 *
 */
public interface VenueEmissionDataRepository extends JpaRepository<VenueEmissionData, Long>  {

	Optional<VenueEmissionData> getByVenueId(Integer mealId);

}
