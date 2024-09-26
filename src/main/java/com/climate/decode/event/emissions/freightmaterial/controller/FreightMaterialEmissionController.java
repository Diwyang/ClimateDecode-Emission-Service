package com.climate.decode.event.emissions.freightmaterial.controller;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RestController;

import com.climate.decode.event.emissions.freightmaterial.api.FreightMaterialEmissionApi;
import com.climate.decode.event.emissions.freightmaterial.dto.FreightMaterialEmissionDataDto;
import com.climate.decode.event.emissions.freightmaterial.facade.FreightMaterialEmissionDataFacade;
import com.climate.decode.event.emissions.response.ApiResponse;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@CrossOrigin(origins = "*", allowedHeaders = "*")
@RequiredArgsConstructor
@RestController
@Slf4j
public class FreightMaterialEmissionController implements FreightMaterialEmissionApi {

	private final FreightMaterialEmissionDataFacade freightMaterialEmissionFacade;
	
	@Override
	public ApiResponse<FreightMaterialEmissionDataDto> createFreightMaterialEmissionData(Integer freightMaterialId, FreightMaterialEmissionDataDto freightMaterialEmissionDataDto) {
		log.info("FreightMaterialEmissionController :: createFreightMaterialEmissionData");
		return ApiResponse.ofSuccess(freightMaterialEmissionFacade.createFreightMaterialEmissionData(freightMaterialId, freightMaterialEmissionDataDto),
				"Data save successfully");
	}

	@Override
	public ApiResponse<FreightMaterialEmissionDataDto> getFreightMaterialEmissionDataByFreightMaterialId(Integer freightMaterialId) {
		log.info("FreightMaterialEmissionController :: getFreightMaterialEmissionDataByFreightMaterialId");
		return ApiResponse.ofSuccess(freightMaterialEmissionFacade.getFreightMaterialEmissionDataByFreightMaterialId(freightMaterialId));
	}

	@Override
	public ApiResponse<String> deleteFreightMaterialEmissionData(Integer freightMaterialId) {
		log.info("FreightMaterialEmissionController :: deleteFreightMaterialEmissionData");
		return ApiResponse.ofSuccess(freightMaterialEmissionFacade.deleteFreightMaterialEmissionData(freightMaterialId));
	}

	@Override
	public ApiResponse<FreightMaterialEmissionDataDto> updateFreightMaterialEmissionData(Integer freightMaterialId, FreightMaterialEmissionDataDto freightMaterialDetailsDto) {
		log.info("FreightMaterialEmissionController :: updateFreightMaterialEmissionData");
		return ApiResponse.ofSuccess(freightMaterialEmissionFacade.updateFreightMaterialEmissionData(freightMaterialDetailsDto), "Data Successfully Updated");
	}

}
