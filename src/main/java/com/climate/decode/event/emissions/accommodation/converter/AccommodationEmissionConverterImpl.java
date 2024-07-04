/**
 * 
 */
package com.climate.decode.event.emissions.accommodation.converter;

import org.springframework.stereotype.Component;

import com.climate.decode.event.emissions.converter.GenericMapper;
import com.climate.decode.event.emissions.accommodation.dto.AccommodationEmissionDataDto;
import com.climate.decode.event.emissions.accommodation.entity.AccommodationEmissionData;

import lombok.RequiredArgsConstructor;

/**
 * @author diwya
 *
 */

@Component
@RequiredArgsConstructor
public class AccommodationEmissionConverterImpl implements AccommodationEmissionConverter {

	private final GenericMapper mapper;

	@Override
	public AccommodationEmissionData toEntity(AccommodationEmissionDataDto dto) {
		return mapper.convert(dto, AccommodationEmissionData.class);
	}

	@Override
	public AccommodationEmissionDataDto toDto(AccommodationEmissionData entity) {
		return mapper.convert(entity, AccommodationEmissionDataDto.class);
	}

	@Override
	public AccommodationEmissionData updateEntity(AccommodationEmissionData entity, AccommodationEmissionDataDto dto) {
		// TODO Auto-generated method stub
		return null;
	}

}
