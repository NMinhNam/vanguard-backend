package com.fpt.vanguard.util;

import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DateUtil {
    public static Date parseDate(String dateString) throws ParseException {
        SimpleDateFormat inputFormat = new SimpleDateFormat("dd/MM/yyyy");
        java.util.Date utilDate = inputFormat.parse(dateString);
        return new Date(utilDate.getTime());
    }

    public static Timestamp convertDateToTimestamp(Date date) {
        if (date == null) {
            return null;
        }
        return Timestamp.from(date.toInstant());
    }
}
