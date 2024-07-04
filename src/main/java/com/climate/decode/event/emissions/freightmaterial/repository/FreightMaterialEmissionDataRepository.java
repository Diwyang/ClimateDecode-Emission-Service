/**
 * 
 */
package com.climate.decode.event.emissions.freightmaterial.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.climate.decode.event.emissions.freightmaterial.entity.FreightMaterialEmissionData;

/**
 * @author diwya
 *
 */
public interface FreightMaterialEmissionDataRepository extends JpaRepository<FreightMaterialEmissionData, Long>  {

	Optional<FreightMaterialEmissionData> getByFreightMaterialId(Integer mealId);

}
