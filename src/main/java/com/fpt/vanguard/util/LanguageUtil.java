package com.fpt.vanguard.util;

import java.text.Normalizer;

public class LanguageUtil {
    public static String removeVietnameseAccents(String input) {
        // Chuẩn hóa chuỗi, tách dấu
        String temp = Normalizer.normalize(input, Normalizer.Form.NFD);
        // Loại bỏ các ký tự dấu
        temp = temp.replaceAll("\\p{InCombiningDiacriticalMarks}+", "");
        // Xử lý riêng chữ Đ và đ
        temp = temp.replaceAll("Đ", "D").replaceAll("đ", "d");
        return temp;
    }

}
