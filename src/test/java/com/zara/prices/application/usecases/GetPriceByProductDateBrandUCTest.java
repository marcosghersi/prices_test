package com.zara.prices.application.usecases;

import com.zara.prices.application.domain.Prices;
import com.zara.prices.application.domain.shared.NoSuchElementException;
import com.zara.prices.application.domain.shared.NotFoundException;
import com.zara.prices.utils.TimeUtils;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.DisplayNameGeneration;
import org.junit.jupiter.api.DisplayNameGenerator;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.TestPropertySource;

import static org.junit.jupiter.api.Assertions.*;

@Slf4j
@SpringBootTest
@AutoConfigureMockMvc
@TestPropertySource(locations="classpath:application-test.properties")
@DisplayNameGeneration(DisplayNameGenerator.ReplaceUnderscores.class)
public class GetPriceByProductDateBrandUCTest {
    @Autowired
    private GetPriceByProductDateBrandUC getPriceByProductDateBrandUC;
    @Value("${productID}")
    private Long productId;
    @Value("${brandID}")
    private Long brandId;
    @Value("${brandName}")
    private String brandName;
    @Value("${dateTest}")
    private String[] dateTest;

    @Value("${dateTestNotRecord}")
    private String dateTestNotRecord;
    @Value("${dateTestNotPrioritized}")
    private String dateTestNotPrioritized;

    @Test
    void executeTestExistingRecord() {
        Prices prices = getPriceByProductDateBrandUC.execute(productId, brandId, TimeUtils.getLocalDateTimeRestPattern(dateTest[0]));
        assertNotNull(prices);
        assertEquals(productId, prices.getProductId());
        assertEquals(brandId, prices.getBrand().getId());
        assertEquals(brandName, prices.getBrand().getName());
    }

    @Test
    public void executeTestNonExistingRecord() {
        Throwable exception = assertThrows(NotFoundException.class, () ->getPriceByProductDateBrandUC.execute(productId, brandId, TimeUtils.getLocalDateTimeRestPattern(dateTestNotRecord)));
        assertEquals("Prices not found", exception.getMessage());
    }
    @Test
    public void executeTestNoPrioritizedPrice() {
        Throwable exception = assertThrows(NoSuchElementException.class, () ->getPriceByProductDateBrandUC.execute(productId, brandId, TimeUtils.getLocalDateTimeRestPattern(dateTestNotPrioritized)));
        assertEquals("No prioritized price found", exception.getMessage());
    }
}
