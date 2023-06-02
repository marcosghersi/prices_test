package com.zara.prices.infaestructure.datasource.entities;

import jakarta.persistence.*;
import lombok.Builder;
import lombok.Getter;

import java.time.LocalDateTime;

@Getter
@Builder
@Entity
@Table(name = "PRICES")
public class PricesEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long productId;
    @Column
    private Integer brandId;
    @Column(columnDefinition = "TIMESTAMP")
    private LocalDateTime startDate;
    @Column(columnDefinition = "TIMESTAMP")
    private LocalDateTime endDate;
    @Column
    private Integer priority;
    @Column
    private Double price;
    @Column
    private String curr;
    @Column
    private Integer priceList;
}
