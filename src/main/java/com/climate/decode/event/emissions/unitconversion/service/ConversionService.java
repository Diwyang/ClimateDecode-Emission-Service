package com.climate.decode.event.emissions.unitconversion.service;

import com.climate.decode.event.emissions.unitconversion.Unit;

public interface ConversionService<U extends Unit> {
    double convert(double value, U fromUnit, U toUnit);
}
