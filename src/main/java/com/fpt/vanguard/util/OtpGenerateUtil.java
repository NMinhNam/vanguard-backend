package com.fpt.vanguard.util;

import java.util.Random;

public class OtpGenerateUtil {
    public static int generateOTP() {
        Random random = new Random();
        int otp = 100000 + random.nextInt(900000);
        return otp;
    }
}
