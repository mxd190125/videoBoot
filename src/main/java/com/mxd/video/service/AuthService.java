package com.mxd.video.service;

import com.mxd.video.pojo.Admin;
import com.mxd.video.pojo.User;

public interface AuthService {

    public int isExitUser(String username);

    public User getUser(String username , String password);

    public Admin getAdmin(String username , String password);

    public int registerUser(String username, String password , String email);

}
