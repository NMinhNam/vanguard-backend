package com.fpt.vanguard.controller;

import com.fpt.vanguard.common.ApiResponse;
import com.fpt.vanguard.service.UploadImageFileService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@RestController
@RequestMapping("api/v1/upload-file")
@RequiredArgsConstructor
@CrossOrigin
public class UploadFIleController {
    private final UploadImageFileService uploadImageFileService;

    @PostMapping("/image")
    public ApiResponse<String> uploadFile
            (@RequestParam("file") MultipartFile file) throws IOException {
        return ApiResponse.<String>builder()
                .status(HttpStatus.OK.value())
                .success(true)
                .data(uploadImageFileService.uploadImage(file))
                .build();
    }
}