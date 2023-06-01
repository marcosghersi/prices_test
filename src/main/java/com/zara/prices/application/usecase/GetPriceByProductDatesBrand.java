package com.zara.prices.application.usecase;

import com.zara.prices.application.domain.Prices;
import com.zara.prices.application.domain.PricesRepository;
import lombok.RequiredArgsConstructor;

import java.util.Optional;
@RequiredArgsConstructor
public class GetPriceByProductDatesBrand {
    private final PricesRepository pricesRepository;

    public Optional<Prices> execute(Integer productId, Long brandId, String startDate, String endDate){

        return this.pricesRepository.findPriceByProductDatesBrand(productId, brandId, startDate, endDate);
    }
}
