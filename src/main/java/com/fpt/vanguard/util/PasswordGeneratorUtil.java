package com.fpt.vanguard.util;

import org.apache.commons.lang3.RandomStringUtils;
import org.springframework.stereotype.Component;

public class PasswordGeneratorUtil {
    private static final int PASSWORD_LENGTH = 10;
    public static String generateRandomPassword() {
        return RandomStringUtils.randomAlphanumeric(PASSWORD_LENGTH);
    }
}
