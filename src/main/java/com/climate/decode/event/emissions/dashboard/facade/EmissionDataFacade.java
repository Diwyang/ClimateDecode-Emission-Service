/**
 * 
 */
package com.climate.decode.event.emissions.dashboard.facade;

import java.util.List;

import com.climate.decode.event.emissions.dashboard.dto.EmissionDataDto;

/**
 * @author diwya
 *
 */
public interface EmissionDataFacade {


	public  List<EmissionDataDto> getEmissionDataByEventId(Integer eventId, String calculationType);
	
	public  List<EmissionDataDto> getEmissionDataByOrganisationId(Integer orgId, String calculationType);

}
