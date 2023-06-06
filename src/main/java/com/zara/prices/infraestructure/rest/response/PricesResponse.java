package com.zara.prices.infraestructure.rest.response;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.zara.prices.infraestructure.rest.utils.Constants;
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
    @JsonFormat(pattern = Constants.JSON_LOCALDATETIME_PATTERN)
    private LocalDateTime startDate;
    @JsonFormat(pattern = Constants.JSON_LOCALDATETIME_PATTERN)
    private LocalDateTime endDate;
    private Integer priority;
    private BigDecimal price;
    private String curr;
    private Integer priceList;
}
