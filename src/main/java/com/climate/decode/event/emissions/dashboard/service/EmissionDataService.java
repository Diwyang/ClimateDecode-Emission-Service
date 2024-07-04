/**
 * 
 */
package com.climate.decode.event.emissions.dashboard.service;

import java.util.Map;

/**
 * @author diwya
 *
 */
public interface EmissionDataService {


	public Double getEmissionDataByEventId(Integer eventId, String calculationType, String key, Map<String, String> catMap);
	
	public Double getEmissionDataByOrganisationId(Integer orgId, String calculationType, String key, Map<String, String> catMap);

}
