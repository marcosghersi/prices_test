package com.zara.prices.infaestructure.datasource.entities;

import jakarta.persistence.Entity;
import lombok.Builder;
import lombok.Getter;

import java.time.LocalDateTime;

@Getter
@Builder
@Entity
public class Prices {
    private Integer productId;
    private Long brandId;
    private LocalDateTime startDate;
    private LocalDateTime endDate;
    private Integer priority;
    private Double price;
    private String curr;
    private Integer priceList;
}
