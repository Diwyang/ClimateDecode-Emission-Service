package com.climate.decode.event.emissions.freightmaterial.facade;

import java.time.OffsetDateTime;
import java.util.Optional;

import org.springframework.stereotype.Component;

import com.climate.decode.event.emissions.exception.ResourceNotFoundException;
import com.climate.decode.event.emissions.freightmaterial.converter.FreightMaterialEmissionConverter;
import com.climate.decode.event.emissions.freightmaterial.dto.FreightMaterialEmissionDataDto;
import com.climate.decode.event.emissions.freightmaterial.entity.FreightMaterialEmissionData;
import com.climate.decode.event.emissions.freightmaterial.service.FreightMaterialEmissionDataService;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;


@Component
@RequiredArgsConstructor
@Slf4j
public class FreightMaterialEmissionDataFacadeImpl implements FreightMaterialEmissionDataFacade {

	private final FreightMaterialEmissionConverter freightMaterialEmissionConverter;
	private final FreightMaterialEmissionDataService freightMaterialEmissionService;
	
	@Override
	public FreightMaterialEmissionDataDto createFreightMaterialEmissionData(Integer freightMaterialId, FreightMaterialEmissionDataDto freightMaterialEmissionDataDto) {
		log.info("FreightMaterialEmissionDataFacade :: createFreightMaterialEmissionData");
		FreightMaterialEmissionData freightMaterialEmission = freightMaterialEmissionConverter.toEntity(freightMaterialEmissionDataDto);
		freightMaterialEmission.setCreatedDateTime(OffsetDateTime.now());
		freightMaterialEmission.setUpdatedDateTime(OffsetDateTime.now());
		freightMaterialEmission = freightMaterialEmissionService.createFreightMaterialEmissionData(freightMaterialEmission);
		return freightMaterialEmissionConverter.toDto(freightMaterialEmission);
	}
	
	@Override
	public FreightMaterialEmissionDataDto getFreightMaterialEmissionDataByFreightMaterialId(Integer freightMaterialId) {
		log.info("FreightMaterialEmissionDataFacade :: getFreightMaterialEmissionDataByFreightMaterialId");
		Optional<FreightMaterialEmissionData> optFreightMaterialEmissionData = freightMaterialEmissionService.getFreightMaterialEmissionDataByFreightMaterialId(freightMaterialId);
		
		FreightMaterialEmissionData freightMaterialEmissionData = !optFreightMaterialEmissionData.isEmpty()? optFreightMaterialEmissionData.get(): null ;
		
		if (null == freightMaterialEmissionData) {
			throw new ResourceNotFoundException(String.format("Record Not Found with freightMaterialId {%x}", freightMaterialId));
		}
		
		return freightMaterialEmissionConverter.toDto(freightMaterialEmissionData);
	}
	
	@Override
	public String deleteFreightMaterialEmissionData(Integer freightMaterialId) {
		log.info("FreightMaterialEmissionDataFacade :: deleteFreightMaterialEmissionData");
		return freightMaterialEmissionService.deleteFreightMaterialEmissionData(freightMaterialId);
	}
	
	@Override
	public FreightMaterialEmissionDataDto updateFreightMaterialEmissionData(FreightMaterialEmissionDataDto freightMaterial) {
		log.info("FreightMaterialEmissionDataFacade :: updateFreightMaterialEmissionData");
		FreightMaterialEmissionData freightMaterialEmission = freightMaterialEmissionConverter.toEntity(freightMaterial);
		freightMaterialEmission.setUpdatedDateTime(OffsetDateTime.now());
		freightMaterialEmission = freightMaterialEmissionService.updateFreightMaterialEmissionData(freightMaterialEmission);
		return freightMaterialEmissionConverter.toDto(freightMaterialEmission);
	}
	
	

}
