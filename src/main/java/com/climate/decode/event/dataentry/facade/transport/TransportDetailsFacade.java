/**
 * 
 */
package com.climate.decode.event.dataentry.facade.transport;

import java.util.List;

import com.climate.decode.event.dataentry.dto.transport.TransportDetailsDto;

/**
 * @author diwya
 *
 */
public interface TransportDetailsFacade {

	public TransportDetailsDto createTransportDetails(Integer eventId, TransportDetailsDto transportDetailsDto);

	public List<TransportDetailsDto> getTransportDetailsByEventId(Integer eventId);
	
	public TransportDetailsDto getTransportDetailsByEventIdAndTransportId(Integer eventId, Integer transportId);

	public String deleteTransportDetails(Integer eventId, Integer transportId);

	public TransportDetailsDto updateTransportDetails(TransportDetailsDto transportDetailsDto);
}
