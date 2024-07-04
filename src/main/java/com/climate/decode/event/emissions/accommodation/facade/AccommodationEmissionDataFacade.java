/**
 * 
 */
package com.climate.decode.event.emissions.accommodation.facade;

import com.climate.decode.event.emissions.accommodation.dto.AccommodationEmissionDataDto;

/**
 * @author diwya
 *
 */
public interface AccommodationEmissionDataFacade {

	public AccommodationEmissionDataDto createAccommodationEmissionData(Integer accommodationId, AccommodationEmissionDataDto accommodationEmissionDataDto);

	public AccommodationEmissionDataDto getAccommodationEmissionDataByAccommodationId(Integer accommodationId);

	public String deleteAccommodationEmissionData(Integer accommodationId);

	public AccommodationEmissionDataDto updateAccommodationEmissionData(AccommodationEmissionDataDto accommodation);
}
