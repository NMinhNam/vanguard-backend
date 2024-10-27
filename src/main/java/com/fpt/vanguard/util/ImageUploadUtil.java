package com.fpt.vanguard.util;

import org.springframework.mock.web.MockMultipartFile;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.Base64;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.nio.file.Files;
import java.util.HashMap;
import java.util.Map;

public class ImageUploadUtil {
    public static String convertImageToBase64(String filePath) throws IOException {
        File file = new File(filePath);
        byte[] fileContent = Files.readAllBytes(file.toPath());
        return Base64.getEncoder().encodeToString(fileContent);
    }

    public static MultipartFile convertBase64ToMultipartFile(String base64, String fileName) throws IOException {
        byte[] decodedBytes = Base64.getDecoder().decode(base64);
        String contentType = determineContentType(fileName);
        return new MockMultipartFile(
                "file",
                fileName,
                contentType,
                new ByteArrayInputStream(decodedBytes)
        );
    }

    private static String determineContentType(String fileName) {
        Map<String, String> contentTypeMap = new HashMap<>();
        contentTypeMap.put(".jpg", "image/jpeg");
        contentTypeMap.put(".jpeg", "image/jpeg");
        contentTypeMap.put(".png", "image/png");
        contentTypeMap.put(".gif", "image/gif");
        contentTypeMap.put(".bmp", "image/bmp");
        contentTypeMap.put(".tiff", "image/tiff");
        contentTypeMap.put(".tif", "image/tiff");
        contentTypeMap.put(".webp", "image/webp");

        for (Map.Entry<String, String> entry : contentTypeMap.entrySet()) {
            if (fileName.toLowerCase().endsWith(entry.getKey())) {
                return entry.getValue();
            }
        }

        return "application/octet-stream";
    }
}
