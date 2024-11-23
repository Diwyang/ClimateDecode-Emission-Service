/**
 * 
 */
package com.climate.decode.event.dataentry.facade.meal;

import java.util.List;

import com.climate.decode.event.dataentry.dto.meal.MealDetailsDto;


/**
 * @author diwya
 *
 */
public interface MealFacade {

	public MealDetailsDto createMealDetails(Integer eventId, MealDetailsDto mealDetailsDto);

	public List<MealDetailsDto> getMealDetailsByEventId(Integer eventId);
	
	public MealDetailsDto getMealDetailsByEventIdAndMealId(Integer eventId, Integer mealId);

	public String deleteMealDetails(Integer eventId, Integer mealId);

	public MealDetailsDto updateMealDetails(MealDetailsDto mealDetailsDto);
}
