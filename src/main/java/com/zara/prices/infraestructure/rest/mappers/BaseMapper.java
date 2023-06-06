package com.zara.prices.infraestructure.rest.mappers;

import java.util.List;

public interface BaseMapper<RE, M> {

    RE toRE(M e);

    M toModel(RE re);

    List<M> toModelList(List<RE> reList);

    List<RE> toREList(List<M> mList);

}
