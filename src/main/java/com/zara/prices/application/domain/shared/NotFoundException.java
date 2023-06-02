package com.zara.prices.application.domain.shared;

public class NotFoundException extends RuntimeException{

    public NotFoundException(String message) {
         super(message);
    }

}
