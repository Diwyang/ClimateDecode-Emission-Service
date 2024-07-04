/**
 * 
 */
package com.climate.decode.event.emissions.freightmaterial.facade;

import com.climate.decode.event.emissions.freightmaterial.dto.FreightMaterialEmissionDataDto;

/**
 * @author diwya
 *
 */
public interface FreightMaterialEmissionDataFacade {

	public FreightMaterialEmissionDataDto createFreightMaterialEmissionData(Integer freightMaterialId, FreightMaterialEmissionDataDto freightMaterialEmissionDataDto);

	public FreightMaterialEmissionDataDto getFreightMaterialEmissionDataByFreightMaterialId(Integer freightMaterialId);

	public String deleteFreightMaterialEmissionData(Integer freightMaterialId);

	public FreightMaterialEmissionDataDto updateFreightMaterialEmissionData(FreightMaterialEmissionDataDto freightMaterial);
}
