package com.zara.prices.application.domain;

import java.time.LocalDateTime;
import java.util.Optional;

public interface PricesRepository {
    Optional<Prices> findPriceByProductDatesBrand(Integer productId, Long brandId, LocalDateTime date);
}
