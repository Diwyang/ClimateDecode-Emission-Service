/**
 * 
 */
package com.climate.decode.event.emissions.meal.converter;

import org.springframework.stereotype.Component;

import com.climate.decode.event.emissions.converter.GenericMapper;
import com.climate.decode.event.emissions.meal.dto.MealEmissionDataDto;
import com.climate.decode.event.emissions.meal.entity.MealEmissionData;

import lombok.RequiredArgsConstructor;

/**
 * @author diwya
 *
 */

@Component
@RequiredArgsConstructor
public class MealEmissionConverterImpl implements MealEmissionConverter {

	private final GenericMapper mapper;

	@Override
	public MealEmissionData toEntity(MealEmissionDataDto dto) {
		return mapper.convert(dto, MealEmissionData.class);
	}

	@Override
	public MealEmissionDataDto toDto(MealEmissionData entity) {
		return mapper.convert(entity, MealEmissionDataDto.class);
	}

	@Override
	public MealEmissionData updateEntity(MealEmissionData entity, MealEmissionDataDto dto) {
		// TODO Auto-generated method stub
		return null;
	}

}
