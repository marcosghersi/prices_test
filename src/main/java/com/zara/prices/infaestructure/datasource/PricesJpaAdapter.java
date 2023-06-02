package com.zara.prices.infaestructure.datasource;

import com.zara.prices.application.domain.Prices;
import com.zara.prices.application.domain.PricesRepository;
import com.zara.prices.infaestructure.datasource.mappers.PricesDSMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.Optional;

@Repository
@RequiredArgsConstructor
public class PricesJpaAdapter implements PricesRepository {

    private final PricesJpaRepository pricesJPARepository;
    @Override
    public Optional<Prices> findPriceByProductDatesBrand(Integer productId, Long brandId, LocalDateTime date) {
        return PricesDSMapper.INSTANCE.toOptionalModel(pricesJPARepository.findByEndDateLessThanEqualAndStartDateGreaterThanEqualAndProductIdAndBrandId(date, date, productId, brandId));
    }
}
