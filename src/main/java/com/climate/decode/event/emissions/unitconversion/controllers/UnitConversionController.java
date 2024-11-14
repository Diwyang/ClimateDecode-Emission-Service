package com.climate.decode.event.emissions.unitconversion.controllers;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;

import com.climate.decode.event.emissions.unitconversion.LengthUnit;
import com.climate.decode.event.emissions.unitconversion.Unit;
import com.climate.decode.event.emissions.unitconversion.api.UnitConversionApi;
import com.climate.decode.event.emissions.unitconversion.service.ConversionService;

public class UnitConversionController implements UnitConversionApi {

	@Autowired
    private Map<String, ConversionService<? extends Unit>> conversionServices;
	
	@Override
	public double convert(double value, String fromUnitType, String fromUnit, String toUnitType, String toUnit) {
		
		ConversionService<? extends Unit> conversionService = getService(fromUnitType, toUnitType);

        // Get the specific units as enums
        Unit fromUnitEnum = getUnitEnum(fromUnitType, fromUnit);
        Unit toUnitEnum = getUnitEnum(toUnitType, toUnit);

        // Perform a safe cast to match generic requirements
        @SuppressWarnings("unchecked")
        ConversionService<Unit> service = (ConversionService<Unit>) conversionService;

        return service.convert(value, fromUnitEnum, toUnitEnum);
    }

    private ConversionService<? extends Unit> getService(String fromUnitType, String toUnitType) {
        if (!fromUnitType.equals(toUnitType)) {
            throw new IllegalArgumentException("Incompatible unit types: " + fromUnitType + " and " + toUnitType);
        }

        return conversionServices.get(fromUnitType + "ConversionService");
    }

    private Unit getUnitEnum(String unitType, String unitName) {
        switch (unitType) {
            case "length":
                return LengthUnit.valueOf(unitName.toUpperCase());
            // Add cases for other unit types here
            default:
                throw new IllegalArgumentException("Unsupported unit type: " + unitType);
        }
    }

}
