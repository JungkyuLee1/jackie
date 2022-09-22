package com.example.fileuploaddownload.mapper;

import com.example.fileuploaddownload.dto.FileUpload;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface UploadMapper {

    public void saveFile(FileUpload fileUpload);
}
