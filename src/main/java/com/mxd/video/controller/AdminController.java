package com.mxd.video.controller;


import com.alibaba.fastjson.JSONObject;
import com.mxd.video.pojo.Category;
import com.mxd.video.pojo.User;
import com.mxd.video.pojo.Video;
import com.mxd.video.service.AdminService;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;
import java.util.UUID;

@CrossOrigin
@RestController
public class AdminController {

    @Resource
    private AdminService adminService;

    @GetMapping("/isExist")
    public JSONObject isExist(String name){
        JSONObject json = new JSONObject();
        if (name != null && !name.equals("")){
            int exist = adminService.isExist(name);
            json.put("status" , adminService.isExist(name) == 0 ? "1" : "0" );
        }else {
            json.put("status" , "0" );
        }
        return json;
    }

    @GetMapping("/addCateName")
    public JSONObject addCateName(String name){
        JSONObject json = new JSONObject();
        if (name != null && !name.equals("")){
            if (adminService.addCateName(name) > 0){
                json.put("status" , "1" );
                json.put("id" , UUID.randomUUID().toString());
            }else {

            }
        }else {
            json.put("status" , "0" );
        }
        return json;
    }

    @GetMapping("/showAllCateName")
    public JSONObject showAllCateName(){
        JSONObject json = new JSONObject();
        List<Category> categorys = adminService.showAllCateName();
        json.put("status" , categorys != null && categorys.size() != 0 ? "1" : "0");
        json.put("categorys" , categorys);
        return json;
    }

    @GetMapping("/showUsersByPage")
    public JSONObject showUsersByPage(Integer page){
        JSONObject json = new JSONObject();
        if (page != null){
            List<User> userList = adminService.showUsersByPage(page);
            if (userList != null && userList.size() !=0){
                int num = adminService.getPageNum();
                json.put("status" , "1");
                json.put("userList" , userList);
                json.put("pageCount" , getPageCount(num));
            }else {
                json.put("status" , "0" );
            }
        }else {
            json.put("status" , "0" );
        }
        return json;
    }

    @GetMapping("/delUser")
    public JSONObject delUser(String username , Integer page){
        JSONObject json = new JSONObject();
        if (username != null && !username.trim().equals("")){
            if (adminService.delUser(username) > 0){
                List<User> userList = adminService.showUsersByPage(page);
                int num = adminService.getPageNum();
                json.put("status" , "1");
                json.put("userList" , userList);
                json.put("pageCount" , getPageCount(num));
            }else {
                json.put("status" , "0" );
            }
        }else {
            json.put("status" , "0" );
        }
        return json;
    }

    @GetMapping("/modPass")
    public JSONObject modPass(String username , String newPass){
        JSONObject json = new JSONObject();
        if (username != null
                && newPass != null
                && !username.equals("")
                && !newPass.equals("")){
            json.put("status" , adminService.modPass(username, newPass) > 0 ? "1" : "0" );
        }else {
            json.put("status" , "0" );
        }
        return json;
    }

    // 按视频名字
    @GetMapping("/checkVideosByVideoName")
    public JSONObject checkVideosByVideoName(String videoName , Integer page){
        JSONObject json = new JSONObject();
        if (videoName != null
                && !videoName.equals("")
                && page != null){
            List<Video> videos = adminService.checkVideosByVideoName(videoName , page);
            if (videos != null && videos.size() != 0){
                int num = adminService.getVNameNum(videoName);
                json.put("status" , "1" );
                json.put("videos" , videos);
                json.put("pageCount" , getPageCount(num));
            }else {
                json.put("status" , "0" );
            }
        }else {
            json.put("status" , "0" );
        }
        return json;
    }

    // 按类别名字
    @GetMapping("/checkVideosByCateName")
    public JSONObject checkVideosByCateName(String cateName , Integer page){
        JSONObject json = new JSONObject();
        if (cateName != null && !cateName.equals("") && page != null){
            List<Video> videos = adminService.checkVideosByCateName(cateName , page);
            if (videos != null && videos.size() != 0){
                int num = adminService.getCNameNum(cateName);
                json.put("status" , "1" );
                json.put("videos" , videos);
                json.put("pageCount" , getPageCount(num));
            }else {
                json.put("status" , "0" );
            }
        }else {
            json.put("status" , "0" );
        }
        return json;
    }

    // 按类别名字和视频名字联合
    @GetMapping("/checkVideosByVCName")
    public JSONObject checkVideosByVCName(String videoName ,String cateName , Integer page){
        JSONObject json = new JSONObject();
        if (cateName != null && videoName != null
                && !cateName.equals("")
                && !videoName.equals("")
                && page != null){
            List<Video> videos = adminService.checkVideosByVCName(videoName , cateName , page);
            if (videos != null && videos.size() != 0){
                int num = adminService.getVCNameNum(videoName, cateName);
                json.put("status" , "1" );
                json.put("videos" , videos);
                json.put("pageCount" , getPageCount(num));
            }else {
                json.put("status" , "0" );
            }
        }else {
            json.put("status" , "0" );
        }
        return json;
    }

    // 查询所有视频
    @GetMapping("/checkAllVideos")
    public JSONObject checkAllVideos(Integer page){
        JSONObject json = new JSONObject();
        List<Video> videos = adminService.checkAllVideos(page);
        if (videos != null && videos.size() != 0){
            int num = adminService.getAllNum();
            json.put("status" , "1" );
            json.put("videos" , videos);
            json.put("pageCount" , getPageCount(num));
        }else {
            json.put("status" , "0" );
        }
        return json;
    }

    private int getPageCount(int num){
        int pageCount = 0;
        if (num <6 && num > 0){
            pageCount = 1;
        }else if (num>0){
            pageCount  = (num%6) > 0 ? num/6 +1 : num/6;
        }
        return pageCount;
    }


}
