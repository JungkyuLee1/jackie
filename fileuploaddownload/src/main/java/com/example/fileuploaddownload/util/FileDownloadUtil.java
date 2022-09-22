package com.example.fileuploaddownload.util;

import org.springframework.core.io.Resource;
import org.springframework.core.io.UrlResource;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

@Service
public class FileDownloadUtil {
    private Path foundFile;

    public Resource getFileAsResource(String fileCode) throws IOException {
        Path uploadDirectory = Paths.get("C:\\download\\Files-Upload\\");

        Files.list(uploadDirectory).forEach(file -> {
            if (file.getFileName().toString().startsWith(fileCode)) {
                foundFile = file;
                return;
            }
        });

        if (foundFile != null) {
            return new UrlResource(foundFile.toUri());
        }
        return null;
    }
}
