package com.climate.decode.event.calculator.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Table(name = "meal_emission_factors")
@Data
public class MealEmissionFactorEntity {
	
	@Id
	private long id;
	
	@Column(name = "food_stuff_type")
    private String foodStuffType;

	@Column(name = "emission_factor")
    private String emissionFactor;

	@Column(name = "unit")
    private String unit;

	@Column(name = "reference")
    private String reference;
	
}
