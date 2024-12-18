package com.fpt.vanguard.util;

import com.fpt.vanguard.dto.request.NhanVienDtoRequest;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.PDPage;
import org.apache.pdfbox.pdmodel.PDPageContentStream;
import org.apache.pdfbox.pdmodel.font.PDType1Font;
import org.apache.pdfbox.pdmodel.graphics.image.PDImageXObject;

import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;

public class EmployeeCardPdfGenerator {
    public static byte[] generateEmployeeCardPdf(NhanVienDtoRequest nhanVienDtoRequest, BufferedImage employeeCardImage) throws IOException, IOException {
        PDDocument document = new PDDocument();

        PDPage page = new PDPage();
        document.addPage(page);

        PDPageContentStream contentStream = new PDPageContentStream(document, page);

        PDImageXObject pdImage = PDImageXObject.createFromFileByContent(new File("path_to_image"), document);
        contentStream.drawImage(pdImage, 100, 500);

        contentStream.setFont(PDType1Font.HELVETICA_BOLD, 18);
        contentStream.beginText();
        contentStream.newLineAtOffset(100, 700);
        contentStream.showText("Mã nhân viên: " + nhanVienDtoRequest.getMaNhanVien());
        contentStream.newLineAtOffset(0, -20);
        contentStream.showText("Tên: " + nhanVienDtoRequest.getHoTen());
        contentStream.newLineAtOffset(0, -20);
        contentStream.showText("Chức vụ: " + nhanVienDtoRequest.getMaChucVu());
        contentStream.endText();

        contentStream.close();

        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        document.save(baos);
        document.close();

        return baos.toByteArray();
    }
}
