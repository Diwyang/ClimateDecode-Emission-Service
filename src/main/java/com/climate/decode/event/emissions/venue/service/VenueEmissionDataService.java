/**
 * 
 */
package com.climate.decode.event.emissions.venue.service;

import java.util.Optional;

import com.climate.decode.event.emissions.venue.entity.VenueEmissionData;

/**
 * @author diwya
 *
 */
public interface VenueEmissionDataService {

	public VenueEmissionData createVenueEmissionData(VenueEmissionData venue);

	public Optional<VenueEmissionData> getVenueEmissionDataByVenueId(Integer venueId);

	public String deleteVenueEmissionData(Integer venueId);

	public VenueEmissionData updateVenueEmissionData(VenueEmissionData meal);
}
