package com.esolution.users.helper;

import java.util.ArrayList;
import java.util.List;

public abstract class AbstractMapper<E, D> {
    public abstract E toEntity(E entity, D dto);
    public abstract D toDto(E entity);
    public List<D> toDtos(List<E> entities) {
        List<D> dtos = new ArrayList<D>();

        for(E entity: entities) {
            dtos.add(toDto(entity));
        }

        return dtos;
    }
}
