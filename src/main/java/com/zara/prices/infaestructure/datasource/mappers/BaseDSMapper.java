package com.zara.prices.infaestructure.datasource.mappers;

import java.util.List;
import java.util.Optional;

public interface BaseDSMapper<M, E> {

    M toModel(E e);

    E toEntity(M m);

    List<E> toEntityList(List<M> mList);

    List<M> toModelList(List<E> eList);

    default Optional<E> toOptionalEntity(Optional<M> m) {
        return m.map(this::toEntity);
    }

    default Optional<M> toOptionalModel(Optional<E> e) {
        return e.map(this::toModel);
    }

}
