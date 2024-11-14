package com.climate.decode.event.emissions.unitconversion.api;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/emission/unit-convert")
public interface UnitConversionApi {

	@GetMapping
    public double convert(
            @RequestParam double value,
            @RequestParam String fromUnitType,
            @RequestParam String fromUnit,
            @RequestParam String toUnitType,
            @RequestParam String toUnit);
}
