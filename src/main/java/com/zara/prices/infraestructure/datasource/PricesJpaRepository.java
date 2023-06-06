package com.zara.prices.infraestructure.datasource;

import com.zara.prices.infraestructure.datasource.entities.PricesEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDateTime;
import java.util.List;

public interface PricesJpaRepository extends JpaRepository<PricesEntity, Long> {
    List<PricesEntity> findByEndDateGreaterThanEqualAndStartDateLessThanEqualAndProductIdAndBrandId(LocalDateTime startDate, LocalDateTime endDate, Long productId, Long brandId);

}
