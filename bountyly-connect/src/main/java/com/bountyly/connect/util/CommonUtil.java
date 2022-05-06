package com.bountyly.connect.util;


import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.UUID;

public class CommonUtil {
    public static String generateRandomUUID () {
        return UUID.randomUUID().toString();
    }

    public static java.sql.Date getCurrentDate () {
        LocalDate todayLocalDate = LocalDate.now();
        java.sql.Date sqlDate = java.sql.Date.valueOf( todayLocalDate );
        return sqlDate;
    }

    public static java.sql.Timestamp getCurrentDateTime () {
        LocalDateTime todayLocalDateTime = LocalDateTime.now();
        java.sql.Timestamp sqlDate = java.sql.Timestamp.valueOf( todayLocalDateTime );
        return sqlDate;
    }
}
