/**
 * 
 */
package com.climate.decode.event.emissions.freightmaterial.converter;

import org.springframework.stereotype.Component;

import com.climate.decode.event.emissions.converter.GenericMapper;
import com.climate.decode.event.emissions.freightmaterial.dto.FreightMaterialEmissionDataDto;
import com.climate.decode.event.emissions.freightmaterial.entity.FreightMaterialEmissionData;

import lombok.RequiredArgsConstructor;

/**
 * @author diwya
 *
 */

@Component
@RequiredArgsConstructor
public class FreightMaterialEmissionConverterImpl implements FreightMaterialEmissionConverter {

	private final GenericMapper mapper;

	@Override
	public FreightMaterialEmissionData toEntity(FreightMaterialEmissionDataDto dto) {
		return mapper.convert(dto, FreightMaterialEmissionData.class);
	}

	@Override
	public FreightMaterialEmissionDataDto toDto(FreightMaterialEmissionData entity) {
		return mapper.convert(entity, FreightMaterialEmissionDataDto.class);
	}

	@Override
	public FreightMaterialEmissionData updateEntity(FreightMaterialEmissionData entity, FreightMaterialEmissionDataDto dto) {
		// TODO Auto-generated method stub
		return null;
	}

}
