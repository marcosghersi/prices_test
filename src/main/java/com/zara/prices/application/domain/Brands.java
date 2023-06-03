package com.zara.prices.application.domain;

import lombok.Builder;
import lombok.Getter;
import lombok.ToString;

@ToString
@Getter
@Builder
public class Brands {

    private Long id;

    private String name;
}
