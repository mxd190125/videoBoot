package com.mxd.video.controller;

import com.alibaba.fastjson.JSONObject;
import com.mxd.video.pojo.Admin;
import com.mxd.video.pojo.User;
import com.mxd.video.service.AuthService;
import com.mxd.video.service.impl.AuthServiceImpl;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@CrossOrigin
@RestController
public class AuthController {

    @Resource
    private AuthService authService = new AuthServiceImpl();

    @PostMapping("/login")
    public JSONObject login(String username , String password){
        JSONObject json = new JSONObject();
        if (username != null && password != null){
            User user = authService.getUser(username, password);
            if (user != null){
                json.put("status" , "1");
                json.put("userId" , user.getId());
                json.put("photoUrl" , user.getPhotoUrl());
                json.put("role" , "USER");
            }else{
                Admin admin = authService.getAdmin(username, password);
                if (admin != null){
                    json.put("status" , "1");
                    json.put("userId" , admin.getId());
                    json.put("photoUrl" , admin.getPhotoUrl());
                    json.put("role" , "ADMIN");
                }else {
                    // 账号或密码错误
                    json.put("status" , "0");
                }
            }
        }else {
            // 输入不完全
            json.put("status" , "0");
        }
        return json;
    }

    @PostMapping("/register")
    public JSONObject register(String username , String password , String  email){
        JSONObject json = new JSONObject();
        if (username != null && password != null && email != null){
            int i = authService.isExitUser(username);
            if (i>0){
                // 已存在
                json.put("status" , "2");
            }else {
                int j = authService.registerUser(username, password, email);
                json.put("status" , j == 1 ? "1" : "0");
            }
        }else {
            json.put("status" , "0");
        }
        return json;
    }
}
