package com.zara.prices.utils;

import com.zara.prices.infraestructure.rest.utils.Constants;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public final class TimeUtils {

    private TimeUtils() {
        throw new IllegalStateException("Utility class");
    }
    private static final DateTimeFormatter DATE_TIME_FORMATTER = DateTimeFormatter.ofPattern(Constants.JSON_LOCALDATETIME_PATTERN);
    public static String formatLocalDateTime(final LocalDateTime localDateTime, final String dateTimePattern) {
        return localDateTime.format(DateTimeFormatter.ofPattern(dateTimePattern));
    }
    public static LocalDateTime getLocalDateTimeRestPattern(String date) {
        return LocalDateTime.parse(date, DATE_TIME_FORMATTER);
    }
}
