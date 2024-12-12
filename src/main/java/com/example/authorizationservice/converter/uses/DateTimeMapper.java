package com.example.authorizationservice.converter.uses;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.Date;

import static com.example.authorizationservice.constant.Constant.DATE_PATTERN;
import static com.example.authorizationservice.constant.Constant.DATE_TIME_PATTERN;

public class DateTimeMapper {

    public static String date(Date date) {
        if (date == null) {
            return null;
        }
        return new SimpleDateFormat(DATE_PATTERN).format(date);
    }

    public static String localDate(LocalDate localDate) {
        if (localDate == null) {
            return null;
        }
        return localDate.format(DateTimeFormatter.ofPattern(DATE_PATTERN));
    }

    public static Date date(String date) {
        if (date == null) {
            return null;
        }
        try {
            return new SimpleDateFormat(DATE_TIME_PATTERN).parse(date);
        } catch (ParseException ex) {
            ex.getMessage();
        }
        throw new RuntimeException();
    }

    public static LocalDate localDate(String localDate) {
        if (localDate == null) {
            return null;
        }
        try{
            return LocalDate.parse(localDate, DateTimeFormatter.ofPattern(DATE_PATTERN));
        } catch (DateTimeParseException ex) {
            ex.printStackTrace();
        }
        throw new RuntimeException();
    }
}
