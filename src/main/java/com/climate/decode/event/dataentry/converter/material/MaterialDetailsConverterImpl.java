/**
 * 
 */
package com.climate.decode.event.dataentry.converter.material;

import org.springframework.stereotype.Component;

import com.climate.decode.event.dataentry.converter.GenericMapper;
import com.climate.decode.event.dataentry.dto.material.MaterialDetailsDto;
import com.climate.decode.event.dataentry.entity.material.MaterialDetails;

import lombok.RequiredArgsConstructor;

/**
 * @author diwya
 *
 */
@Component
@RequiredArgsConstructor
public class MaterialDetailsConverterImpl implements MaterialDetailsConverter {

	private final GenericMapper mapper;
	
	@Override
	public MaterialDetails toEntity(MaterialDetailsDto dto) {
		return mapper.convert(dto, MaterialDetails.class);
	}

	@Override
	public MaterialDetailsDto toDto(MaterialDetails entity) {
		return mapper.convert(entity, MaterialDetailsDto.class);
	}

	@Override
	public MaterialDetails updateEntity(MaterialDetails entity, MaterialDetailsDto dto) {
		// TODO Auto-generated method stub
		return null;
	}

}
