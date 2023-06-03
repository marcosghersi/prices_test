package com.zara.prices.application.usecases;

import com.zara.prices.application.domain.Prices;
import com.zara.prices.application.domain.PricesRepository;
import com.zara.prices.application.domain.shared.NoSuchElementException;
import com.zara.prices.application.domain.shared.NotFoundException;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.time.LocalDateTime;
import java.util.Comparator;
import java.util.List;

@Slf4j
@Service
@RequiredArgsConstructor
public class GetPriceByProductDateBrandUC {

    private final PricesRepository pricesRepository;

    public Prices execute(Integer productId, Long brandId, LocalDateTime date){
        List<Prices> pricesList = this.pricesRepository.findPriceByProductDatesBrand(productId, brandId, date);
        if(CollectionUtils.isEmpty(pricesList)){
            throw new NotFoundException("Prices not found");
        }
        log.debug("Number of Prices found: {}", pricesList.size());
        return pricesList.stream().max(Comparator.comparing(Prices::getPriority)).orElseThrow(() -> new NoSuchElementException("No prioritized price found"));
    }
}
