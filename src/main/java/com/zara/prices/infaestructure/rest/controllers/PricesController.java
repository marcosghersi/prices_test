package com.zara.prices.infaestructure.rest.controllers;

import com.zara.prices.application.usecase.GetPriceByProductDatesBrandUC;
import com.zara.prices.infaestructure.rest.mappers.PriceMapper;
import com.zara.prices.infaestructure.rest.response.PricesResponse;
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

    private final GetPriceByProductDatesBrandUC getPriceByProductDatesBrandUC;

   @GetMapping
   public ResponseEntity<PricesResponse> getPriceByProductDatesBrand(@RequestParam Integer productId, @RequestParam Long brandId, @RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME)
   LocalDateTime date) {
       log.info("getPriceByProductDatesBrand productId: {}, brandId: {}, date: {}", productId, brandId, date);
       return ResponseEntity.ok(PriceMapper.INSTANCE.toRE(getPriceByProductDatesBrandUC.execute(productId, brandId, date)));
   }




}
