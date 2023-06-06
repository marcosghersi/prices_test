package com.zara.prices.infraestructure.datasource;

import com.zara.prices.application.domain.Prices;
import com.zara.prices.application.domain.PricesRepository;
import com.zara.prices.infraestructure.datasource.mappers.PricesDSMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;

@Repository
@RequiredArgsConstructor
public class PricesJpaAdapter implements PricesRepository {

    private final PricesJpaRepository pricesJPARepository;
    @Override
    public List<Prices> findPriceByProductDatesBrand(Long productId, Long brandId, LocalDateTime date) {
        return PricesDSMapper.INSTANCE.toModelList(pricesJPARepository.findByEndDateGreaterThanEqualAndStartDateLessThanEqualAndProductIdAndBrandId(date, date, productId, brandId));
    }
}
