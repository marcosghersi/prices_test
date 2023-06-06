package com.zara.prices.infraestructure.rest.mappers;

import com.zara.prices.application.domain.Prices;
import com.zara.prices.infraestructure.rest.response.PricesResponse;
import org.mapstruct.Mapper;
import org.mapstruct.NullValuePropertyMappingStrategy;
import org.mapstruct.factory.Mappers;

@Mapper(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
public interface PriceMapper extends BaseMapper<PricesResponse, Prices>{
    PriceMapper INSTANCE = Mappers.getMapper(PriceMapper.class);
}
