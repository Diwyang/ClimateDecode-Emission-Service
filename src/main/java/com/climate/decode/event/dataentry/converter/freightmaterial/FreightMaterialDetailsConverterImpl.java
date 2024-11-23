/**
 * 
 */
package com.climate.decode.event.dataentry.converter.freightmaterial;

import org.springframework.stereotype.Component;

import com.climate.decode.event.dataentry.converter.GenericMapper;
import com.climate.decode.event.dataentry.dto.freightmaterial.FreightMaterialDetailsDto;
import com.climate.decode.event.dataentry.entity.freightmaterial.FreightMaterialDetails;

import lombok.RequiredArgsConstructor;

/**
 * @author diwya
 *
 */
@Component
@RequiredArgsConstructor
public class FreightMaterialDetailsConverterImpl implements FreightMaterialDetailsConverter {

	private final GenericMapper mapper;
	
	@Override
	public FreightMaterialDetails toEntity(FreightMaterialDetailsDto dto) {
		return mapper.convert(dto, FreightMaterialDetails.class);
	}

	@Override
	public FreightMaterialDetailsDto toDto(FreightMaterialDetails entity) {
		return mapper.convert(entity, FreightMaterialDetailsDto.class);
	}

	@Override
	public FreightMaterialDetails updateEntity(FreightMaterialDetails entity, FreightMaterialDetailsDto dto) {
		// TODO Auto-generated method stub
		return null;
	}

}
