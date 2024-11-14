package com.climate.decode.event.emissions.calculator.service;

import com.climate.decode.event.emissions.calculator.repository.EmissionFactorProjection;

public interface EmissionFactorService {

	public EmissionFactorProjection getEmissionFactorBySource(String source, String country);

}
