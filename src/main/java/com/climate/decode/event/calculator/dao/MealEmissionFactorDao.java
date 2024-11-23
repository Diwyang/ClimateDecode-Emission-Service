package com.climate.decode.event.calculator.dao;

import com.climate.decode.event.calculator.model.EmissionFactor;

import jakarta.persistence.EntityManager;
import jakarta.persistence.Query;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class MealEmissionFactorDao implements EmissionFactorDao{

	private EntityManager entityManager;
	
	private final static String QUERYSTRING = "select 'Meal' as source, emission_factor as factor, unit from  meal_emission_factors where food_stuff_type = '<foodStuffType>'";
	
	public EmissionFactor getEmissionFactorByCountry(String foodStuffType) {
		
		String sql = QUERYSTRING.replace("<foodStuffType>", foodStuffType);
		
		Query q = entityManager.createNativeQuery(sql, EmissionFactor.class);
        return (EmissionFactor) q.getResultList();

	}

}
