package com.zara.prices.infaestructure.rest.response;

import lombok.Builder;
import lombok.Getter;
import lombok.ToString;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@ToString
@Getter
@Builder
public class PricesResponse {
    private Long id;
    private Long productId;
    private Brands brand;
    private LocalDateTime startDate;
    private LocalDateTime endDate;
    private Integer priority;
    private BigDecimal price;
    private String curr;
    private Integer priceList;
}
