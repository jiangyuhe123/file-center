package com.ajavac.controller.api;

import org.apache.commons.io.FileUtils;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;

/**
 * Created by wyp0596 on 09/03/2017.
 */
@RestController
@RequestMapping("api/upload")
public class MyFileController {

    @Value("${my.file.dir}")
    private String dir;

    @PostMapping(value = "common")
    public String commonUpload(@RequestParam("file") MultipartFile tmpFile) throws IllegalStateException, IOException {
        long startTime = System.currentTimeMillis();
        System.out.println(tmpFile.getOriginalFilename());
        FileUtils.copyToFile(tmpFile.getInputStream(), new File(dir + tmpFile.getOriginalFilename()));
        long endTime = System.currentTimeMillis();
        System.out.println("运行时间：" + String.valueOf(endTime - startTime) + "ms");
        return "{\"result\":\"ok\"}";
    }
}
