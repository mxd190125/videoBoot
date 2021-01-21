package com.mxd.video.controller;

import com.alibaba.fastjson.JSONObject;
import com.mxd.video.pojo.History;
import com.mxd.video.pojo.Video;
import com.mxd.video.service.UserService;
import com.mxd.video.utils.UpLoadUtils;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import java.util.List;

@CrossOrigin
@RestController
public class UserController {

    @Resource
    private UserService userService;

    @GetMapping("/getCategorys")
    public JSONObject getCategorys(){
        JSONObject json = new JSONObject();
        json.put("status" , "1");
        json.put("categorys" , userService.getCategorys());
        return json;
    }

    @PostMapping("/subVideo")
    public JSONObject subVideo(@RequestBody Video video){
        JSONObject json = new JSONObject();
        System.out.println(video);
        int i = userService.subVideo(video);
        json.put("status" , i>0 ? "1" : "0");
        return json;
    }

    @PostMapping("/upload")
    public JSONObject subVideoFace(MultipartFile file){
        JSONObject json = new JSONObject();
        String url = UpLoadUtils.uploadImage(file);
        if (url != null){
            json.put("status" , "1");
            json.put("url" , url);
        }else {
            json.put("status" , "0");
        }
        return json;
    }

    @GetMapping("/updatePhotoUrl")
    public JSONObject updatePhotoUrl(String photoUrl, Integer userId) {
        JSONObject json = new JSONObject();
        if (photoUrl != null && !photoUrl.equals("") && userId != null) {
            int i = userService.updatePhotoUrl(photoUrl, userId);
            json.put("status" , i > 0 ? "1" : "0");
        }else {
            json.put("status" , "0");
        }

        return json;
    }

    @GetMapping("/getMyVideos")
    public JSONObject getMyVideos(Integer userId){
        JSONObject json = new JSONObject();
        List<Video> videos = userService.getMyVideos(userId);
        if (videos != null && videos.size() !=0){
            json.put("status" , "1");
            json.put("videos" , videos);
        }else {
            json.put("status" , "0");
        }
        return json;
    }

    @GetMapping("/getHistoryByVideoId")
    public JSONObject getHistoryByVideoId(Integer videoId){
        JSONObject json = new JSONObject();
        List<History> historys = userService.getHistoryByVideoId(videoId);
        if (historys != null && historys.size() !=0){
            json.put("status" , "1");
            json.put("historys" , historys);
        }
        else {
            json.put("status" , "0");
        }
        return json;
    }

    @GetMapping("/showAllVideos")
    public JSONObject showAllVideos(){
        JSONObject json = new JSONObject();
        List<Video> videos = userService.showAllVideos();
        if (videos != null && videos.size() !=0){
            json.put("status" , "1");
            json.put("videos" , videos);
        }else {
            json.put("status" , "0");
        }
        return json;
    }
}
