package com.yztc.beibaotu.springmvc.util;

import org.apache.commons.io.FileUtils;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;

import java.io.File;
import java.io.IOException;

public class DownloadUtil {
    public static ResponseEntity<byte[]> download (String path,String fileName)throws IOException {
        File file = new File(path);
        HttpHeaders headers = new HttpHeaders();
        //为了解决中文名称乱码
        //设置文件名以及文件后缀名
        String fileNames = new String(fileName.getBytes("UTF-8"),"iso-8859-1");
        headers.setContentDispositionFormData("attachment",fileNames);
        headers.setContentType(MediaType.APPLICATION_OCTET_STREAM);

        return new ResponseEntity<byte[]>(FileUtils.readFileToByteArray(file),
                headers, HttpStatus.CREATED);
    }
}
