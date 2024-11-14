package com.climate.decode.event.emissions.calculator.model;

public class EmissionFactor {
	private String source;
	private String unit;
	private double factor;

	// Constructors, getters, and setters

	public EmissionFactor(String source, String unit, double factor) {
		this.source = source;
		this.unit = unit;
		this.factor = factor;
	}

	public String getSource() {
		return source;
	}

	public String getUnit() {
		return unit;
	}

	public double getFactor() {
		return factor;
	}
}
