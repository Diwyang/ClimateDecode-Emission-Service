package com.climate.decode.event.calculator.service;

import com.climate.decode.event.calculator.repository.EmissionFactorProjection;

public interface EmissionFactorService {

	public EmissionFactorProjection getEmissionFactorBySource(String source, String country);

}
