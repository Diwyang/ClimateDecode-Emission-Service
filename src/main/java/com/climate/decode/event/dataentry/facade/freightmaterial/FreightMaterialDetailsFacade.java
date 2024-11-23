/**
 * 
 */
package com.climate.decode.event.dataentry.facade.freightmaterial;

import java.util.List;

import com.climate.decode.event.dataentry.dto.freightmaterial.FreightMaterialDetailsDto;

/**
 * @author diwya
 *
 */
public interface FreightMaterialDetailsFacade {

	public FreightMaterialDetailsDto createFreightMaterialDetails(Integer eventId, FreightMaterialDetailsDto dto);

	public List<FreightMaterialDetailsDto> getFreightMaterialDetailsByEventId(Integer eventId);
	
	public FreightMaterialDetailsDto getFreightMaterialDetailsByEventIdAndFreightMaterialId(Integer eventId, Integer freightMaterialId);

	public String deleteFreightMaterialDetails(Integer eventId, Integer freightMaterialId);

	public FreightMaterialDetailsDto updateFreightMaterialDetails(FreightMaterialDetailsDto dto);
}
