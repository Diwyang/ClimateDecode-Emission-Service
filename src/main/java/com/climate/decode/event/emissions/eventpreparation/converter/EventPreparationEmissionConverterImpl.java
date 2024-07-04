/**
 * 
 */
package com.climate.decode.event.emissions.eventpreparation.converter;

import org.springframework.stereotype.Component;

import com.climate.decode.event.emissions.converter.GenericMapper;
import com.climate.decode.event.emissions.eventpreparation.dto.EventPreparationEmissionDataDto;
import com.climate.decode.event.emissions.eventpreparation.entity.EventPreparationEmissionData;

import lombok.RequiredArgsConstructor;

/**
 * @author diwya
 *
 */

@Component
@RequiredArgsConstructor
public class EventPreparationEmissionConverterImpl implements EventPreparationEmissionConverter {

	private final GenericMapper mapper;

	@Override
	public EventPreparationEmissionData toEntity(EventPreparationEmissionDataDto dto) {
		return mapper.convert(dto, EventPreparationEmissionData.class);
	}

	@Override
	public EventPreparationEmissionDataDto toDto(EventPreparationEmissionData entity) {
		return mapper.convert(entity, EventPreparationEmissionDataDto.class);
	}

	@Override
	public EventPreparationEmissionData updateEntity(EventPreparationEmissionData entity, EventPreparationEmissionDataDto dto) {
		// TODO Auto-generated method stub
		return null;
	}

}
