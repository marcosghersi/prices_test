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
import java.util.stream.Collectors;

@Slf4j
@Service
@RequiredArgsConstructor
public class GetPriceByProductDateBrandUC {

    private final PricesRepository pricesRepository;

    public Prices execute(Long productId, Long brandId, LocalDateTime date){
        List<Prices> pricesList = this.pricesRepository.findPriceByProductDatesBrand(productId, brandId, date);
        if(CollectionUtils.isEmpty(pricesList)){
            throw new NotFoundException("Prices not found");
        }
        log.debug("Number of Prices found: {}", pricesList.size());

        Prices princesMax = pricesList.stream().max(Comparator.comparing(Prices::getPriority)).orElseThrow(() -> new NoSuchElementException("No prioritized price found"));

        List<Prices> pricesMaxList = pricesList.stream().filter(prices -> prices.getPriority().equals(princesMax.getPriority())).collect(Collectors.toList());

        log.warn("Number of Prices with max priority found: {}", pricesMaxList.size());
        if(pricesMaxList.size() > 1){
            throw new NoSuchElementException("No prioritized price found");
        }

        return pricesMaxList.get(0);
    }

    private static long getMaxOccurrences(List<Prices> pricesList) {
        return pricesList.stream()
                .collect(Collectors.groupingBy(Prices::getPriority, Collectors.counting()))
                .values()
                .stream()
                .max(Long::compare)
                .orElse(0L);
    }
}
