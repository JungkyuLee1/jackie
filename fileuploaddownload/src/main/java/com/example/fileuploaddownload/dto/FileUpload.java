package com.example.fileuploaddownload.dto;

import lombok.*;
import org.springframework.stereotype.Component;

@AllArgsConstructor
@NoArgsConstructor
@Data
@ToString
@Getter
@Setter
@Component
public class FileUpload {
    private int id;
    private String fileName;
    private String downloadUrl;
    private Long size;
}
