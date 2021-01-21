package com.mxd.video.controller;

import com.alibaba.fastjson.JSONObject;
import com.mxd.video.pojo.Discuss;
import com.mxd.video.pojo.Video;
import com.mxd.video.service.VideoService;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

@CrossOrigin
@RestController
public class VideoController {

    @Resource
    private VideoService videoService;

    @GetMapping("/isFavor")
    public JSONObject isFavor(Integer videoId , Integer userId){
        JSONObject json = new JSONObject();
        if (videoId != null && userId != null){
            int i = videoService.isFavor(videoId, userId);
            json.put("status" , i > 0 ? "1" : "0");
        }else {
            json.put("status" , "0");
        }
        return json;
    }

    @GetMapping("/favor")
    public JSONObject favor(Integer videoId , Integer userId){
        JSONObject json = new JSONObject();
        if (videoId != null && userId != null){
            int i = videoService.favor(videoId, userId);
            json.put("status" , i > 0 ? "1" : "0");
        }else {
            json.put("status" , "0");
        }
        return json;
    }

    @GetMapping("/cancelFavor")
    public JSONObject cancelFavor(Integer videoId , Integer userId){
        JSONObject json = new JSONObject();
        if (videoId != null && userId != null){
            int i = videoService.cancelFavor(videoId, userId);
            json.put("status" , i > 0 ? "1" : "0");
        }else {
            json.put("status" , "0");
        }
        return json;
    }

    @GetMapping("/isPraise")
    public JSONObject isPraise(Integer videoId , Integer userId){
        JSONObject json = new JSONObject();
        if (videoId != null && userId != null){
            int i = videoService.isPraise(videoId, userId);
            json.put("status" , i > 0 ? "1" : "0");
        }else {
            json.put("status" , "0");
        }
        return json;
    }

    @GetMapping("/praise")
    public JSONObject praise(Integer videoId , Integer userId){
        JSONObject json = new JSONObject();
        if (videoId != null && userId != null){
            int i = videoService.praise(videoId, userId);
            json.put("status" , i > 0 ? "1" : "0");
        }else {
            json.put("status" , "0");
        }
        return json;
    }

    @GetMapping("/cancelPraise")
    public JSONObject cancelPraise(Integer videoId , Integer userId){
        JSONObject json = new JSONObject();
        if (videoId != null && userId != null){
            int i = videoService.cancelPraise(videoId, userId);
            json.put("status" , i > 0 ? "1" : "0");
        }else {
            json.put("status" , "0");
        }
        return json;
    }


    @GetMapping("/addViewNum")
    public JSONObject addViewNum(Integer videoId , Integer userId){
        JSONObject json = new JSONObject();
        if (videoId != null && userId != null){
            int i = videoService.addViewNum(videoId , userId);
            json.put("status" , i > 0 ? "1" : "0");
        }else {
            json.put("status" , "0");
        }
        return json;
    }

    @GetMapping("/getOptVideos")
    public JSONObject getOptVideos(String type , Integer userId){
        JSONObject json = new JSONObject();
        if (type != null && !type.trim().equals("") && userId != null){
            List<Video> videos = null;
            // 获取“我收藏的视频”
            if (type.equals("collect")){
                videos = videoService.getCollectVideos(userId);
            }else if (type.equals("praise")){
                // 获取“我点赞的视频”
                videos = videoService.getPraiseVideos(userId);
            }else if (type.equals("watch")){
                // 获取“我观看过的视频”
                videos = videoService.getWatchVideos(userId);
            }

            if (videos != null && videos.size() !=0){
                json.put("status" , "1");
                json.put("videos" , videos);
            }else {
                json.put("status" , "0");
            }
        }else {
            json.put("status" , "0");
        }

        return json;
    }

    // 查询某个视频的评论
    @GetMapping("/checkVideoDiscusses")
    public JSONObject checkVideoDiscusses(Integer videoId){
        JSONObject json = new JSONObject();
        if (videoId != null) {
            List<Discuss> discusses = videoService.checkVideoDiscusses(videoId);
            if (discusses != null && discusses.size() != 0) {
                json.put("status", "1");
                json.put("discusses" , discusses);
            }
        }else {
            json.put("status" , "0");
        }

        return json;
    }

    // 查看某个用户评论过的视频
    @GetMapping("/checkDiscussedVideos")
    public JSONObject checkDiscussedVideos(Integer userId){
        JSONObject json = new JSONObject();
        if (userId != null) {
            List<Video> videos = videoService.checkDiscussedVideos(userId);
            if (videos != null && videos.size() != 0) {
                json.put("status", "1");
                json.put("videos" , videos);
            }
        }else {
            json.put("status" , "0");
        }

        return json;
    }

    // 用户评论
    @GetMapping("/subDiscuss")
    public JSONObject subDiscuss(Integer videoId , Integer userId , String content) {
        JSONObject json = new JSONObject();
        if (videoId != null && userId != null && content != null) {
            int i = videoService.subDiscuss(videoId, userId, content);
            json.put("status" , i > 0 ? "1" : "0");
        }else {
            json.put("status" , "0");
        }
        return json;
    }

}
