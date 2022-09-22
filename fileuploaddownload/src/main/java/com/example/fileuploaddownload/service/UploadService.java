package com.example.fileuploaddownload.service;

import com.example.fileuploaddownload.dto.FileUpload;
import com.example.fileuploaddownload.mapper.UploadMapper;
import com.example.fileuploaddownload.util.FileUploadUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@Service
@Slf4j
public class UploadService {

    @Autowired
    private FileUploadUtil fileUploadUtil;

    @Autowired
    private UploadMapper uploadMapper;

    @Autowired
    private FileUpload fileUpload;

    public FileUpload fileUpload(MultipartFile multipartFile) throws IOException {

        String fileName=StringUtils.cleanPath(multipartFile.getOriginalFilename());
        Long size=multipartFile.getSize();
        //File 저장(Disk)
        String fileCode=fileUploadUtil.saveFile(fileName,multipartFile);

        fileUpload.setFileName(fileName);
        fileUpload.setSize(size);
        fileUpload.setDownloadUrl("C:\\download\\Files-Upload\\" + fileCode+fileName);

        log.info("FileUpload : " +fileUpload);
        //File 저장(Table)
        uploadMapper.saveFile(fileUpload);

        return fileUpload;

    }
}
