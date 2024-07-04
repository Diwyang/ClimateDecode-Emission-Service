package com.climate.decode.event.emissions.converter;

import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

public interface Converter<E, D> {
	E toEntity(D dto);

	D toDto(E entity);

	E updateEntity(E entity, D dto);

	default List<D> createFromEntities(final Collection<E> entities) {
		return entities.stream().map(this::toDto).collect(Collectors.toList());
	}

	default List<E> createFromDtos(final Collection<D> dtos) {
		return dtos.stream().map(this::toEntity).collect(Collectors.toList());
	}
}
