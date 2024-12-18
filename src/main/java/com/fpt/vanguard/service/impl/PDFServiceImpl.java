package com.fpt.vanguard.service.impl;

import com.fpt.vanguard.service.PDFService;
import com.fpt.vanguard.service.QRCodeService;
import com.fpt.vanguard.util.LanguageUtil;
import lombok.RequiredArgsConstructor;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.PDPage;
import org.apache.pdfbox.pdmodel.PDPageContentStream;
import org.apache.pdfbox.pdmodel.font.PDTrueTypeFont;
import org.apache.pdfbox.pdmodel.graphics.image.PDImageXObject;
import org.springframework.stereotype.Service;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;

@Service
@RequiredArgsConstructor
public class PDFServiceImpl implements PDFService {
    private final QRCodeService qrCodeService;

    @Override
    public byte[] generateEmployeeCardPdf(String employeeCode, String employeeName, String employeeRole) throws Exception {
        employeeCode = LanguageUtil.removeVietnameseAccents(employeeCode);
        employeeName = LanguageUtil.removeVietnameseAccents(employeeName);
        employeeRole = LanguageUtil.removeVietnameseAccents(employeeRole);

        PDDocument document = new PDDocument();
        PDPage page = new PDPage();
        document.addPage(page);

        PDPageContentStream contentStream = new PDPageContentStream(document, page);

        InputStream fontStream = getClass().getClassLoader().getResourceAsStream("fonts/NotoSans-Regular.ttf");
        if (fontStream == null) {
            throw new IOException("Không thể tìm thấy font tại đường dẫn: fonts/NotoSans-Regular.ttf");
        }

        // Tải font TrueType từ InputStream
        PDTrueTypeFont font = PDTrueTypeFont.loadTTF(document, fontStream);
        contentStream.setFont(font, 14);

        // Đảm bảo đóng InputStream sau khi sử dụng
        fontStream.close();

        contentStream.beginText();
        contentStream.newLineAtOffset(20, 750);

        contentStream.showText("Employee ID: " + employeeCode);
        contentStream.newLineAtOffset(0, -20);
        contentStream.showText("Name: " + employeeName);
        contentStream.newLineAtOffset(0, -20);
        contentStream.showText("Role: " + employeeRole);
        contentStream.endText();

        BufferedImage qrCodeImage = qrCodeService.generateQRCode(employeeCode);
        if (qrCodeImage != null) {
            int qrCodeX = 612 - 150 - 20;
            int qrCodeY = 600;

            PDImageXObject qrCodePdImage = PDImageXObject.createFromByteArray(document, imageToByteArray(qrCodeImage), "qrCodeImage");
            contentStream.drawImage(qrCodePdImage, qrCodeX, qrCodeY, 150, 150);
        }


        contentStream.close();

        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        document.save(baos);

        document.close();

        return baos.toByteArray();
    }

    private byte[] imageToByteArray(BufferedImage image) throws IOException {
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        ImageIO.write(image, "PNG", baos);
        return baos.toByteArray();
    }
}
