/**
 * 
 */
package com.climate.decode.event.dataentry.service.transport;

import java.util.List;
import java.util.Optional;

import com.climate.decode.event.dataentry.entity.transport.TransportDetails;

/**
 * @author diwya
 *
 */
public interface TransportService {

	public TransportDetails createTransportDetailsData(TransportDetails	 transportDetail);

	public List<TransportDetails> getTransportDetailsDataByEventId(Integer eventId);
	
	public Optional<TransportDetails> getTransportDetailsDataByEventIdAndTransportId(Integer eventId, Integer transportId);

	public void deleteTransportDetailsData(Integer eventId, Integer transportId);

	public TransportDetails updateTransportDetailsData(TransportDetails transportDetail);
}
