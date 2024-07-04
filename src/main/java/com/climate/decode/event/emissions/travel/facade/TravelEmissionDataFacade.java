/**
 * 
 */
package com.climate.decode.event.emissions.travel.facade;

import com.climate.decode.event.emissions.travel.dto.TravelEmissionDataDto;

/**
 * @author diwya
 *
 */
public interface TravelEmissionDataFacade {

	public TravelEmissionDataDto createTravelEmissionData(Integer travelId, TravelEmissionDataDto travelEmissionDataDto);

	public TravelEmissionDataDto getTravelEmissionDataByTravelId(Integer travelId);

	public String deleteTravelEmissionData(Integer travelId);

	public TravelEmissionDataDto updateTravelEmissionData(TravelEmissionDataDto travel);
}
