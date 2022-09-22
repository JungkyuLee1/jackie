package com.example.fileuploaddownload.controller;

import com.example.fileuploaddownload.dto.FileUpload;
import com.example.fileuploaddownload.service.UploadService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@RestController
public class FileUploadController {
    @Autowired
    private UploadService uploadService;

    @PostMapping("/upload")
    public ResponseEntity<FileUpload> uploadFile(@RequestParam("file") MultipartFile multipartFile) throws IOException {

        FileUpload fileUpload = uploadService.fileUpload(multipartFile);

        return ResponseEntity.status(HttpStatus.OK).body(fileUpload);
    }


}
