package com.fpt.vanguard.service;

import java.awt.image.BufferedImage;

public interface QRCodeService {
    BufferedImage generateQRCode(String employeeCode) throws Exception;
}
