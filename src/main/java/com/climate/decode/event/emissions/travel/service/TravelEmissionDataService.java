/**
 * 
 */
package com.climate.decode.event.emissions.travel.service;

import java.util.Optional;

import com.climate.decode.event.emissions.travel.entity.TravelEmissionData;

/**
 * @author diwya
 *
 */
public interface TravelEmissionDataService {

	public TravelEmissionData createTravelEmissionData(TravelEmissionData travel);

	public Optional<TravelEmissionData> getTravelEmissionDataByTravelId(Integer travelId);

	public String deleteTravelEmissionData(Integer travelId);

	public TravelEmissionData updateTravelEmissionData(TravelEmissionData meal);
}
