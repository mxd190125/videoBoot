package com.mxd.video.service.impl;

import com.mxd.video.dao.AuthDao;
import com.mxd.video.pojo.Admin;
import com.mxd.video.pojo.User;
import com.mxd.video.service.AuthService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class AuthServiceImpl implements AuthService {

    @Resource
    private AuthDao authDao;

    @Override
    public int isExitUser(String username) {
        return authDao.isExitUser(username);
    }

    @Override
    public User getUser(String username, String password) {
        return authDao.getUser(username, password);
    }

    @Override
    public Admin getAdmin(String username, String password) {
        return authDao.getAdmin(username, password);
    }

    @Override
    public int registerUser(String username, String password, String email) {
        return authDao.registerUser(username, password, email);
    }
}
