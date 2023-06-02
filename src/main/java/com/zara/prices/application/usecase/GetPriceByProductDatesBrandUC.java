package com.zara.prices.application.usecase;

import com.zara.prices.application.domain.Prices;
import com.zara.prices.application.domain.PricesRepository;
import com.zara.prices.application.domain.shared.NotFoundException;
import lombok.RequiredArgsConstructor;

import java.time.LocalDateTime;

@RequiredArgsConstructor
public class GetPriceByProductDatesBrandUC {

    private final PricesRepository pricesRepository;

    public Prices execute(Integer productId, Long brandId, LocalDateTime date){

        return this.pricesRepository.findPriceByProductDatesBrand(productId, brandId, date).orElseThrow(() -> new NotFoundException("Price not found"));
    }
}
