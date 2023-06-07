package com.zara.prices.infraestructure.datasource;


import com.zara.prices.infraestructure.datasource.entities.PricesEntity;
import com.zara.prices.utils.TimeUtils;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.util.CollectionUtils;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(SpringExtension.class)
@DataJpaTest
@TestPropertySource(locations="classpath:application-test.properties")
public class PricesJpaAdapterTest {

    @Autowired
    private PricesJpaRepository pricesJPARepository;

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
    public void findPriceByProductDatesBrandTest() {
        List<PricesEntity> prices = pricesJPARepository.findByEndDateGreaterThanEqualAndStartDateLessThanEqualAndProductIdAndBrandId(TimeUtils.getLocalDateTimeRestPattern(dateTest[0]), TimeUtils.getLocalDateTimeRestPattern(dateTest[0]), productId, brandId);

        assertNotNull(prices);
        assertFalse(CollectionUtils.isEmpty(prices));
        assertEquals(productId, prices.get(0).getProductId());
        assertEquals(brandId, prices.get(0).getBrand().getId());
        assertEquals(brandName, prices.get(0).getBrand().getName());
    }
    @Test
    public void notFindPriceByProductDatesBrandTest() {
        List<PricesEntity> prices = pricesJPARepository.findByEndDateGreaterThanEqualAndStartDateLessThanEqualAndProductIdAndBrandId(TimeUtils.getLocalDateTimeRestPattern(dateTestNotRecord), TimeUtils.getLocalDateTimeRestPattern(dateTestNotRecord), productId, brandId);

        assertTrue(CollectionUtils.isEmpty(prices));

    }
}
