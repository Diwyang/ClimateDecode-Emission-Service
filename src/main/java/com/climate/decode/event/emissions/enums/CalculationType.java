package com.climate.decode.event.emissions.enums;

public enum CalculationType {

	PRE(Names.PRE), ABATE(Names.ABATE);

	public static class Names {
		public static final String PRE = "PRE";
		public static final String ABATE = "ABATE";
	}

	private final String calculationType;

	private CalculationType(String calculationType) {
		this.calculationType = calculationType;
	}

	@Override
	public String toString() {
		return this.calculationType;
	}
}
