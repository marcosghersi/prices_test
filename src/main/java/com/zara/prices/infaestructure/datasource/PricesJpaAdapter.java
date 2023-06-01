package com.zara.prices.infaestructure.datasource;

import com.zara.prices.application.domain.Prices;
import com.zara.prices.application.domain.PricesRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
@RequiredArgsConstructor
public class PricesJpaAdapter implements PricesRepository {

    private final PricesJPARepository pricesJPARepository;
    @Override
    public Optional<Prices> findPriceByProductDatesBrand(Integer productId, Long brandId, String startDate, String endDate) {
        return null;
    }
}
