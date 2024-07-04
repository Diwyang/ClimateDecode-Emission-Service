package com.climate.decode.event.emissions.converter;

import java.time.OffsetDateTime;
import java.time.format.DateTimeFormatter;

import org.dozer.DozerConverter;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class ZonedDateTimeConverter extends DozerConverter<OffsetDateTime, OffsetDateTime> {

	private static final DateTimeFormatter FORMATTER = DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm:ss.SSSZ");

    public ZonedDateTimeConverter() {
        super(OffsetDateTime.class, OffsetDateTime.class);
        log.info("Initialize ZonedDateTimeConverter......");
    }

    @Override
    public OffsetDateTime convertTo(OffsetDateTime source, OffsetDateTime destination) {
        if (source == null) {
            return null;
        }
        log.info("OffsetDateTime :: convertTo");
        return source;
    }

    @Override
    public OffsetDateTime convertFrom(OffsetDateTime source, OffsetDateTime destination) {
        if (source == null) {
            return null;
        }
        log.info("OffsetDateTime :: convertFrom");
        return source;
    }
    
}
