package com.zara.prices.infaestructure.datasource;

import com.zara.prices.infaestructure.datasource.entities.Prices;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface PricesJPARepository  extends JpaRepository<Prices, Long> {
}
