/**
 * 
 */
package com.climate.decode.event.dataentry.controllers.material;

import java.util.List;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RestController;

import com.climate.decode.event.dataentry.api.material.MaterialDetailsApi;
import com.climate.decode.event.dataentry.dto.material.MaterialDetailsDto;
import com.climate.decode.event.dataentry.facade.material.MaterialDetailsFacade;
import com.climate.decode.event.response.ApiResponse;

import lombok.RequiredArgsConstructor;

/**
 * @author diwya
 *
 */

@CrossOrigin(origins = "*", allowedHeaders = "*")
@RequiredArgsConstructor
@RestController
public class MaterialDetailsController implements MaterialDetailsApi {

	private final MaterialDetailsFacade materialDetailsFacade; 
	@Override
	public ApiResponse<MaterialDetailsDto> createMaterialDetails(Integer eventId,
			MaterialDetailsDto materialDetailsDto) {
		return ApiResponse.ofSuccess(materialDetailsFacade.createMaterialDetails(eventId, materialDetailsDto),"Data save successfully");
	}

	@Override
	public ApiResponse<List<MaterialDetailsDto>> getMaterialDetailsByEventId(Integer eventId) {
		return ApiResponse.ofSuccess(materialDetailsFacade.getMaterialDetailsByEventId(eventId));
	}

	@Override
	public ApiResponse<String> deleteMaterialDetails(Integer eventId, Integer accommodationId) {
		return ApiResponse.ofSuccess(materialDetailsFacade.deleteMaterialDetails(eventId, accommodationId));
	}

	@Override
	public ApiResponse<MaterialDetailsDto> updateMaterialDetails(Integer eventId,
			MaterialDetailsDto materialDetailsDto) {
		materialDetailsDto.setEventId(eventId);
		return ApiResponse.ofSuccess(materialDetailsFacade.updateMaterialDetails(materialDetailsDto),"Data Successfully Updated");
	}

	@Override
	public ApiResponse<MaterialDetailsDto> getMaterialDetailsByMaterialId(Integer eventId,
			Integer materialId) {
		return ApiResponse.ofSuccess(materialDetailsFacade.getMaterialDetailsByEventIdAndMaterialId(eventId, materialId));
	}

}
