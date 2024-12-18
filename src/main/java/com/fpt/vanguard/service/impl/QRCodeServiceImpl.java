package com.fpt.vanguard.service.impl;

import com.fpt.vanguard.service.QRCodeService;
import com.google.zxing.BarcodeFormat;
import com.google.zxing.EncodeHintType;
import com.google.zxing.qrcode.QRCodeWriter;
import com.google.zxing.common.BitMatrix;
import org.springframework.stereotype.Service;

import java.awt.Color;
import java.awt.image.BufferedImage;
import java.util.Hashtable;

@Service
public class QRCodeServiceImpl implements QRCodeService {
    @Override
    public BufferedImage generateQRCode(String employeeCode) throws Exception {
        QRCodeWriter qrCodeWriter = new QRCodeWriter();
        Hashtable<EncodeHintType, Object> hintMap = new Hashtable<>();
        hintMap.put(EncodeHintType.MARGIN, 1);
        BitMatrix bitMatrix = qrCodeWriter.encode(employeeCode, BarcodeFormat.QR_CODE, 150, 150, hintMap);

        BufferedImage image = new BufferedImage(150, 150, BufferedImage.TYPE_INT_RGB);
        for (int i = 0; i < 150; i++) {
            for (int j = 0; j < 150; j++) {
                image.setRGB(i, j, bitMatrix.get(i, j) ? Color.BLACK.getRGB() : Color.WHITE.getRGB());
            }
        }
        return image;
    }
}