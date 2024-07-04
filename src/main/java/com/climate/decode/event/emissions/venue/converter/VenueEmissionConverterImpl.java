/**
 * 
 */
package com.climate.decode.event.emissions.venue.converter;

import org.springframework.stereotype.Component;

import com.climate.decode.event.emissions.converter.GenericMapper;
import com.climate.decode.event.emissions.venue.dto.VenueEmissionDataDto;
import com.climate.decode.event.emissions.venue.entity.VenueEmissionData;

import lombok.RequiredArgsConstructor;

/**
 * @author diwya
 *
 */

@Component
@RequiredArgsConstructor
public class VenueEmissionConverterImpl implements VenueEmissionConverter {

	private final GenericMapper mapper;

	@Override
	public VenueEmissionData toEntity(VenueEmissionDataDto dto) {
		return mapper.convert(dto, VenueEmissionData.class);
	}

	@Override
	public VenueEmissionDataDto toDto(VenueEmissionData entity) {
		return mapper.convert(entity, VenueEmissionDataDto.class);
	}

	@Override
	public VenueEmissionData updateEntity(VenueEmissionData entity, VenueEmissionDataDto dto) {
		// TODO Auto-generated method stub
		return null;
	}

}
