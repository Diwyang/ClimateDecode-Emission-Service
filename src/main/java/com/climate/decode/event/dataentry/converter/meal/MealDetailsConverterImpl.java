/**
 * 
 */
package com.climate.decode.event.dataentry.converter.meal;

import org.springframework.stereotype.Component;

import com.climate.decode.event.dataentry.converter.GenericMapper;
import com.climate.decode.event.dataentry.dto.meal.MealDetailsDto;
import com.climate.decode.event.dataentry.entity.meal.MealDetails;

import lombok.RequiredArgsConstructor;

/**
 * @author diwya
 *
 */
@Component
@RequiredArgsConstructor
public class MealDetailsConverterImpl implements MealDetailsConverter {

	private final GenericMapper mapper;
	
	@Override
	public MealDetails toEntity(MealDetailsDto dto) {
		return mapper.convert(dto, MealDetails.class);
	}

	@Override
	public MealDetailsDto toDto(MealDetails entity) {
		return mapper.convert(entity, MealDetailsDto.class);
	}

	@Override
	public MealDetails updateEntity(MealDetails entity, MealDetailsDto dto) {
		// TODO Auto-generated method stub
		return null;
	}

}
