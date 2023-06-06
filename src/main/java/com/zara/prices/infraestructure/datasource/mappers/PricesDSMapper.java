package com.zara.prices.infraestructure.datasource.mappers;

import com.zara.prices.application.domain.Prices;
import com.zara.prices.infraestructure.datasource.entities.PricesEntity;
import org.mapstruct.Mapper;
import org.mapstruct.NullValuePropertyMappingStrategy;
import org.mapstruct.factory.Mappers;

@Mapper(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
public interface PricesDSMapper extends BaseDSMapper<Prices, PricesEntity> {

    PricesDSMapper INSTANCE = Mappers.getMapper(PricesDSMapper.class);
}
