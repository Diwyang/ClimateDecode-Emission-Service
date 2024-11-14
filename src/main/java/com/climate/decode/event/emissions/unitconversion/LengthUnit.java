package com.climate.decode.event.emissions.unitconversion;

public enum  LengthUnit  implements Unit {

	METER("meter"),
    KILOMETER("kilometer"),
    INCH("inch"),
    FOOT("foot"),
    MILE("mile");

    private final String name;

    LengthUnit(String name) {
        this.name = name;
    }
    
	@Override
	public String getName() {
		return name;
	}

}
