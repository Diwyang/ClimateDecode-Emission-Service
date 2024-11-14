package com.climate.decode.event.emissions.calculator.dao;

import com.climate.decode.event.emissions.calculator.model.EmissionFactor;

import jakarta.persistence.EntityManager;
import jakarta.persistence.Query;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class AccomdationEmissionFactorDao implements EmissionFactorDao{

	private EntityManager entityManager;
	
	private final static String QUERYSTRING = "select 'Accomdation' as source, emission_factor as factor, unit from  accomdation_emission_factors where country = '<country>'";
	
	public EmissionFactor getEmissionFactorByCountry(String country) {
		
		String sql = QUERYSTRING.replace("<country>", country);
		
		Query q = entityManager.createNativeQuery(sql, EmissionFactor.class);
        return (EmissionFactor) q.getResultList();

	}

}
