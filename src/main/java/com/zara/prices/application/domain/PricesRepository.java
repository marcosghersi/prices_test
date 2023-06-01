package com.zara.prices.application.domain;

import java.util.List;
import java.util.Optional;

public interface PricesRepository {
    Optional<Prices> findPriceByProductDatesBrand(Integer productId, Long brandId, String startDate, String endDate);
}
