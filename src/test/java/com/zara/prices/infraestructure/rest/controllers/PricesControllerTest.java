package com.zara.prices.infraestructure.rest.controllers;

import com.jayway.jsonpath.JsonPath;
import com.zara.prices.utils.TimeUtils;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.DisplayNameGeneration;
import org.junit.jupiter.api.DisplayNameGenerator;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.MockMvcPrint;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.web.servlet.MockMvc;

import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.concurrent.atomic.AtomicInteger;

import static org.springframework.http.MediaType.APPLICATION_JSON;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@Slf4j
@SpringBootTest
@AutoConfigureMockMvc(print = MockMvcPrint.NONE)
@TestPropertySource(locations="classpath:application-test.properties")
@DisplayNameGeneration(DisplayNameGenerator.ReplaceUnderscores.class)
public class PricesControllerTest {

    @Autowired
    private MockMvc mockMvc;

    private static final String TIME_PATTERN = "HH:mm";

    @Value("${productID}")
    private String productId;
    @Value("${brandID}")
    private String brandId;
    @Value("${brandName}")
    private String brandName;
    @Value("${dateTest}")
    private String[] dateTest;

    @Value("${dateTestNotRecord}")
    private String dateTestNotRecord;

    @Test
    public void getOnePricePerDate() throws Exception {
        AtomicInteger index = new AtomicInteger(1);
        Arrays.stream(dateTest).map(d -> {

            LocalDateTime ld = TimeUtils.getLocalDateTimeRestPattern(d);
            String responseJson = getOnePrice(productId, brandId, d);
            return new String[]{
                    TimeUtils.formatLocalDateTime(ld, TIME_PATTERN),
                    String.valueOf(ld.getDayOfMonth()),
                    JsonPath.read(responseJson, "$.productId").toString(),
                    JsonPath.read(responseJson, "$.brand.id").toString(),
                    JsonPath.read(responseJson, "$.brand.name")
            };

        }).forEach(r -> {
            log.info("Test {}: petición a las {} del día {} del producto {}   para la brand {} ({})", index.getAndIncrement(), r[0], r[1], r[2], r[3], r[4]);
        });

    }
    @Test
    public void getBadRequestDueToOneParamLeft() throws Exception {
        this.mockMvc.perform(get("/prices")
                            .param("productId", this.productId)
                            .param("brandId", this.brandId))
                    .andExpect(status().isBadRequest());

    }

    @Test
    public void getNotFoundException() throws Exception {
        this.mockMvc.perform(get("/prices")
                        .param("productId", this.productId)
                        .param("brandId", this.brandId)
                        .param("date", this.dateTestNotRecord))
                .andExpect(status().isNotFound());

    }

    private String getOnePrice(String productId, String brandId, String date)  {
        final String responseJson;
        try {
            responseJson = this.mockMvc.perform(get("/prices")
                            .param("productId", productId)
                            .param("brandId", brandId)
                            .param("date", date))
                    .andDo(print())
                    .andExpect(status().isOk())
                    .andExpect(content().contentType(APPLICATION_JSON))
                    .andExpect(jsonPath("$.productId").value(this.productId))
                    .andExpect(jsonPath("$.brand.id").value(this.brandId))
                    .andExpect(jsonPath("$.brand.name").value(this.brandName))
                    .andReturn().getResponse().getContentAsString();
        } catch (Exception e) {
            log.error("Error testing getOnePrice", e);
            throw new RuntimeException(e);
        }

        String startDateValue = JsonPath.read(responseJson, "$.startDate");
        String endDateValue = JsonPath.read(responseJson, "$.endDate");
        log.info("startDateValue: {} - endDateValue: {} ", startDateValue, endDateValue);
        LocalDateTime startDate = TimeUtils.getLocalDateTimeRestPattern(startDateValue);
        LocalDateTime endDate = TimeUtils.getLocalDateTimeRestPattern(endDateValue);

        assert startDate.isBefore(TimeUtils.getLocalDateTimeRestPattern(date));
        assert endDate.isAfter(TimeUtils.getLocalDateTimeRestPattern(date));
        return responseJson;

    }


}
