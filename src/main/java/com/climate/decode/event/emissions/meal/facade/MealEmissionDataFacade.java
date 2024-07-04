/**
 * 
 */
package com.climate.decode.event.emissions.meal.facade;

import com.climate.decode.event.emissions.meal.dto.MealEmissionDataDto;

/**
 * @author diwya
 *
 */
public interface MealEmissionDataFacade {

	public MealEmissionDataDto createMealEmissionData(Integer mealId, MealEmissionDataDto mealEmissionDataDto);

	public MealEmissionDataDto getMealEmissionDataByMealId(Integer mealId);

	public String deleteMealEmissionData(Integer mealId);

	public MealEmissionDataDto updateMealEmissionData(MealEmissionDataDto meal);
}
