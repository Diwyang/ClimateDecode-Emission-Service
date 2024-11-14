package com.climate.decode.event.emissions.unitconversion.service;

import org.springframework.stereotype.Service;

import com.climate.decode.event.emissions.unitconversion.LengthUnit;

@Service
public class LengthConversionService implements ConversionService<LengthUnit> {

	@Override
    public double convert(double value, LengthUnit fromUnit, LengthUnit toUnit) {
        if (fromUnit == toUnit) {
            return value;
        }

        double valueInMeters = toMeters(value, fromUnit);
        return fromMeters(valueInMeters, toUnit);
    }

    private double toMeters(double value, LengthUnit unit) {
        switch (unit) {
            case METER:
                return value;
            case KILOMETER:
                return value * 1000;
            case INCH:
                return value * 0.0254;
            case FOOT:
                return value * 0.3048;
            case MILE:
                return value * 1609.34;
            default:
                throw new IllegalArgumentException("Unsupported unit: " + unit);
        }
    }

    private double fromMeters(double value, LengthUnit unit) {
        switch (unit) {
            case METER:
                return value;
            case KILOMETER:
                return value / 1000;
            case INCH:
                return value / 0.0254;
            case FOOT:
                return value / 0.3048;
            case MILE:
                return value / 1609.34;
            default:
                throw new IllegalArgumentException("Unsupported unit: " + unit);
        }
    }
	

}
