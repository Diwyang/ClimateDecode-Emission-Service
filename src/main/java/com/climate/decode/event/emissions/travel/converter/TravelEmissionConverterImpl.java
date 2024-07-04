/**
 * 
 */
package com.climate.decode.event.emissions.travel.converter;

import org.springframework.stereotype.Component;

import com.climate.decode.event.emissions.converter.GenericMapper;
import com.climate.decode.event.emissions.travel.dto.TravelEmissionDataDto;
import com.climate.decode.event.emissions.travel.entity.TravelEmissionData;

import lombok.RequiredArgsConstructor;

/**
 * @author diwya
 *
 */

@Component
@RequiredArgsConstructor
public class TravelEmissionConverterImpl implements TravelEmissionConverter {

	private final GenericMapper mapper;

	@Override
	public TravelEmissionData toEntity(TravelEmissionDataDto dto) {
		return mapper.convert(dto, TravelEmissionData.class);
	}

	@Override
	public TravelEmissionDataDto toDto(TravelEmissionData entity) {
		return mapper.convert(entity, TravelEmissionDataDto.class);
	}

	@Override
	public TravelEmissionData updateEntity(TravelEmissionData entity, TravelEmissionDataDto dto) {
		// TODO Auto-generated method stub
		return null;
	}

}
