package com.example.crm.additional;

import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@Component
public class DateTime {
    public String getFormattedDateTime() {
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");  // NEED TO CREATE NEW CLASS FOR THIS
        LocalDateTime now = LocalDateTime.now();

        return dtf.format(now);
    }
}
