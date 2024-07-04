/**
 * 
 */
package com.climate.decode.event.emissions.venue.facade;

import com.climate.decode.event.emissions.venue.dto.VenueEmissionDataDto;

/**
 * @author diwya
 *
 */
public interface VenueEmissionDataFacade {

	public VenueEmissionDataDto createVenueEmissionData(Integer venueId, VenueEmissionDataDto venueEmissionDataDto);

	public VenueEmissionDataDto getVenueEmissionDataByVenueId(Integer venueId);

	public String deleteVenueEmissionData(Integer venueId);

	public VenueEmissionDataDto updateVenueEmissionData(VenueEmissionDataDto venue);
}
