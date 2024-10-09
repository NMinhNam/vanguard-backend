package com.fpt.vanguard.util;

import com.fpt.vanguard.exception.AppException;
import com.fpt.vanguard.enums.ErrorCode;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Objects;

public class FormatDate {
    /**
     * <h1>
     * Hàm đổi định dạng chuỗi ngày thành chuỗi ngày theo định dạng mới
     * </h1>
     *
     * @param dateString         chuỗi ngày truyền vào
     * @param typeDateFormatFrom định dạng gốc của chuỗi ngày truyền vào
     * @param typeDateFormatTo   định dạng muốn chuỗi ngày trở thành
     * @return chuỗi ngày sau khi định dạng
     */
    public static String formatDateStringToStringFormat(String dateString, String typeDateFormatFrom, String typeDateFormatTo) {
        if (Objects.isNull(dateString) || dateString.trim().isEmpty()) {
            return null;
        }
        SimpleDateFormat inputFormatter = new SimpleDateFormat(typeDateFormatFrom);
        SimpleDateFormat outputFormatter = new SimpleDateFormat(typeDateFormatTo);
        try {
            Date date = inputFormatter.parse(dateString);
            return outputFormatter.format(date);
        } catch (ParseException e) {
            throw new AppException(ErrorCode.DATE_EXCEPTION);
        }
    }
}
