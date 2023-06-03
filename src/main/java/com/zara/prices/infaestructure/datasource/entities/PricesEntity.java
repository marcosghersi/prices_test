package com.zara.prices.infaestructure.datasource.entities;

import jakarta.persistence.*;
import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Data
@Entity
@Table(name = "PRICES")
public class PricesEntity {
    private static final String ID_SEQUENCE = "ID_SEQUENCE";
    @Id
    @GeneratedValue(generator = ID_SEQUENCE)
    private Long id;
    @Column
    private Long productId;
    @Column
    private Long brandId;
    @Column(columnDefinition = "TIMESTAMP")
    private LocalDateTime startDate;
    @Column(columnDefinition = "TIMESTAMP")
    private LocalDateTime endDate;
    @Column
    private Integer priority;
    @Column
    private BigDecimal price;
    @Column
    private String curr;
    @Column
    private Integer priceList;
}
