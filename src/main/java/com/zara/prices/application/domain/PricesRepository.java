package com.zara.prices.application.domain;

import java.time.LocalDateTime;
import java.util.List;

public interface PricesRepository {
    List<Prices> findPriceByProductDatesBrand(Integer productId, Long brandId, LocalDateTime date);
}
