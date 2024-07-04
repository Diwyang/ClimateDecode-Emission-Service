package com.climate.decode.event.emissions.dashboard.mapper;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import com.climate.decode.event.emissions.dashboard.dto.EmissionDataDto;

@Component
public class DashboardMapper {

	 public EmissionDataDto convertResultSetToChargeBoxResponse(String key, Double response) {
	    	EmissionDataDto dto;
				dto = new EmissionDataDto();
				dto.setCategory(key);
				dto.setTotalCo2Eq(response);
				
			return dto;
	    }
}
