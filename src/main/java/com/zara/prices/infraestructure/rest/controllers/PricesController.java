package com.zara.prices.infraestructure.rest.controllers;

import com.zara.prices.application.usecases.GetPriceByProductDateBrandUC;
import com.zara.prices.infraestructure.rest.mappers.PriceMapper;
import com.zara.prices.infraestructure.rest.response.PricesResponse;
import com.zara.prices.infraestructure.rest.utils.Constants;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;

@RestController
@RequestMapping("/prices")
@RequiredArgsConstructor
@Slf4j
public class PricesController {

    private final GetPriceByProductDateBrandUC getPriceByProductDatesBrandUC;

   @GetMapping
   public ResponseEntity<PricesResponse> getPriceByProductDatesBrand(@RequestParam Long productId, @RequestParam Long brandId, @RequestParam @DateTimeFormat(pattern= Constants.JSON_LOCALDATETIME_PATTERN)
   LocalDateTime date) {
       log.info("getPriceByProductDatesBrand productId: {}, brandId: {}, date: {}", productId, brandId, date);
       return ResponseEntity.ok(PriceMapper.INSTANCE.toRE(getPriceByProductDatesBrandUC.execute(productId, brandId, date)));
   }




}
