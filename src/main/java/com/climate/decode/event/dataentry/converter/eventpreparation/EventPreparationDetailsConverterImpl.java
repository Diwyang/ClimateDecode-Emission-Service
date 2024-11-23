/**
 * 
 */
package com.climate.decode.event.dataentry.converter.eventpreparation;

import org.springframework.stereotype.Component;

import com.climate.decode.event.dataentry.converter.GenericMapper;
import com.climate.decode.event.dataentry.dto.eventpreparation.EventPreparationDetailsDto;
import com.climate.decode.event.dataentry.entity.eventpreparation.EventPreparationDetails;

import lombok.RequiredArgsConstructor;

/**
 * @author diwya
 *
 */
@Component
@RequiredArgsConstructor
public class EventPreparationDetailsConverterImpl implements EventPreparationDetailsConverter {

	private final GenericMapper mapper;
	
	@Override
	public EventPreparationDetails toEntity(EventPreparationDetailsDto dto) {
		return mapper.convert(dto, EventPreparationDetails.class);
	}

	@Override
	public EventPreparationDetailsDto toDto(EventPreparationDetails entity) {
		return mapper.convert(entity, EventPreparationDetailsDto.class);
	}

	@Override
	public EventPreparationDetails updateEntity(EventPreparationDetails entity, EventPreparationDetailsDto dto) {
		// TODO Auto-generated method stub
		return null;
	}

}
