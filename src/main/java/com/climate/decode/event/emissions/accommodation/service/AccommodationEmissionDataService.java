/**
 * 
 */
package com.climate.decode.event.emissions.accommodation.service;

import java.util.Optional;

import com.climate.decode.event.emissions.accommodation.entity.AccommodationEmissionData;

/**
 * @author diwya
 *
 */
public interface AccommodationEmissionDataService {

	public AccommodationEmissionData createAccommodationEmissionData(AccommodationEmissionData accommodation);

	public Optional<AccommodationEmissionData> getAccommodationEmissionDataByAccommodationId(Integer accommodationId);

	public String deleteAccommodationEmissionData(Integer accommodationId);

	public AccommodationEmissionData updateAccommodationEmissionData(AccommodationEmissionData accommodation);
}
