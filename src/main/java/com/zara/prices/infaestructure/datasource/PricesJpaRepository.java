package com.zara.prices.infaestructure.datasource;

import com.zara.prices.infaestructure.datasource.entities.PricesEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDateTime;
import java.util.Optional;

public interface PricesJpaRepository extends JpaRepository<PricesEntity, Long> {

    Optional<PricesEntity> findByEndDateLessThanEqualAndStartDateGreaterThanEqualAndProductIdAndBrandId(LocalDateTime startDate, LocalDateTime endDate, Integer productId, Long brandId);

}
