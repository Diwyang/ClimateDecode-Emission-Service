package com.climate.decode.event.emissions.freightmaterial.api;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import com.climate.decode.event.emissions.response.ApiResponse;
import com.climate.decode.event.emissions.freightmaterial.dto.FreightMaterialEmissionDataDto;


@RequestMapping("/emission/freight-materials")
public interface FreightMaterialEmissionApi {

	@PostMapping("/{freightMaterialId}")
	public ApiResponse<FreightMaterialEmissionDataDto> createFreightMaterialEmissionData(@PathVariable(value = "freightMaterialId") Integer freightMaterialId, @RequestBody FreightMaterialEmissionDataDto freightMaterialDetailsDto);
	
	
	@GetMapping("/{freightMaterialId}")
	public ApiResponse<FreightMaterialEmissionDataDto> getFreightMaterialEmissionDataByFreightMaterialId(@PathVariable(value = "freightMaterialId") Integer freightMaterialId);

	
	@DeleteMapping("/{freightMaterialId}")
	public ApiResponse<String> deleteFreightMaterialEmissionData(@PathVariable(value = "freightMaterialId") Integer freightMaterialId);
	
	@PatchMapping("")
	public ApiResponse<FreightMaterialEmissionDataDto> updateFreightMaterialEmissionData(@PathVariable(value = "freightMaterialId") Integer freightMaterialId, @RequestBody FreightMaterialEmissionDataDto freightMaterialDetailsDto);
	
	
}
