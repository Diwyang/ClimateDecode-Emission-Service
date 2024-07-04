/**
 * 
 */
package com.climate.decode.event.emissions.freightmaterial.service;

import java.util.Optional;

import com.climate.decode.event.emissions.freightmaterial.entity.FreightMaterialEmissionData;

/**
 * @author diwya
 *
 */
public interface FreightMaterialEmissionDataService {

	public FreightMaterialEmissionData createFreightMaterialEmissionData(FreightMaterialEmissionData freightMaterial);

	public Optional<FreightMaterialEmissionData> getFreightMaterialEmissionDataByFreightMaterialId(Integer freightMaterialId);

	public String deleteFreightMaterialEmissionData(Integer freightMaterialId);

	public FreightMaterialEmissionData updateFreightMaterialEmissionData(FreightMaterialEmissionData meal);
}
