/**
 * 
 */
package com.climate.decode.event.dataentry.converter.virtualevent;

import org.springframework.stereotype.Component;

import com.climate.decode.event.dataentry.converter.GenericMapper;
import com.climate.decode.event.dataentry.dto.virtualevent.VirtualEventDetailsDto;
import com.climate.decode.event.dataentry.entity.virtualevent.VirtualEventDetails;

import lombok.RequiredArgsConstructor;

/**
 * @author diwya
 *
 */
@Component
@RequiredArgsConstructor
public class VirtualEventDetailsConverterImpl implements VirtualEventDetailsConverter {

	private final GenericMapper mapper;
	
	@Override
	public VirtualEventDetails toEntity(VirtualEventDetailsDto dto) {
		return mapper.convert(dto, VirtualEventDetails.class);
	}

	@Override
	public VirtualEventDetailsDto toDto(VirtualEventDetails entity) {
		return mapper.convert(entity, VirtualEventDetailsDto.class);
	}

	@Override
	public VirtualEventDetails updateEntity(VirtualEventDetails entity, VirtualEventDetailsDto dto) {
		// TODO Auto-generated method stub
		return null;
	}

}
