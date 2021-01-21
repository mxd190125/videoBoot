package com.mxd.video.utils;

import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.UUID;

public class UpLoadUtils {

//    private final static String IP_ADDR = "http://localhost:8080";
//    private final static String dirPath1 = "D:\\myVideo\\img\\";
//    private final static String dirPath2 = "D:\\myVideo\\video\\";

    private final static String IP_ADDR = "http://121.196.145.152:8080";
    private final static String dirPath1 = "/usr/local/myVideo/img/";
    private final static String dirPath2 = "/usr/local/myVideo/video/";

    public static String uploadImage(MultipartFile file){
        String originalFilename = file.getOriginalFilename();
        int index = originalFilename.lastIndexOf(".");
        String type = originalFilename.substring(index);
        String s = UUID.randomUUID().toString().replace("-" , "");
        String newFileName = s.substring(s.length()-8) + type;
        File tempFile = null;
        System.out.println(type);
        if (type.equals(".mp4")){
            tempFile = new File(dirPath2 + newFileName);
            newFileName = IP_ADDR + "/video/" + newFileName;
        }else {
            tempFile = new File(dirPath1 + newFileName);
            newFileName =  IP_ADDR + "/img/" + newFileName;
        }

        try {
            file.transferTo(tempFile);
        }catch (IOException e){
            e.printStackTrace();
            return null;
        }
        return newFileName;
    }


}
