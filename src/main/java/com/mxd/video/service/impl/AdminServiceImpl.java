package com.mxd.video.service.impl;


import com.mxd.video.dao.AdminDao;
import com.mxd.video.pojo.Category;
import com.mxd.video.pojo.User;
import com.mxd.video.pojo.Video;
import com.mxd.video.service.AdminService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class AdminServiceImpl implements AdminService {

    @Resource
    private AdminDao adminDao;

    @Override
    public int isExist(String name) {
        return adminDao.isExist(name);
    }

    @Override
    public int addCateName(String name) {
        return adminDao.addCateName(name);
    }

    @Override
    public List<Category> showAllCateName() {
        return adminDao.showAllCateName();
    }

    @Override
    public List<User> showUsersByPage(int page) {
        return adminDao.showUsersByPage((page-1)*6);
    }

    @Override
    public int getPageNum() {
        return adminDao.getPageNum();
    }

    @Override
    public int delUser(String username) {
        return adminDao.delUser(username);
    }

    @Override
    public int modPass(String username, String newPass) {
        return adminDao.modPass(username, newPass);
    }

    @Override
    public List<Video> checkVideosByVideoName(String videoName  , int page) {
        return adminDao.checkVideosByVideoName(videoName  , (page-1)*6);
    }

    @Override
    public List<Video> checkVideosByCateName(String cateName , int page) {
        return adminDao.checkVideosByCateName(cateName, (page-1)*6);
    }

    @Override
    public List<Video> checkVideosByVCName(String videoName, String cateName , int page) {
        return adminDao.checkVideosByVCName(videoName, cateName , (page-1)*6);
    }

    @Override
    public List<Video> checkAllVideos(int page) {
        return adminDao.checkAllVideos((page-1)*6);
    }

    @Override
    public int getVNameNum(String videoName) {
        return adminDao.getVNameNum(videoName);
    }

    @Override
    public int getCNameNum(String cateName) {
        return adminDao.getCNameNum(cateName);
    }

    @Override
    public int getVCNameNum(String videoName, String cateName) {
        return adminDao.getVCNameNum(videoName, cateName);
    }

    @Override
    public int getAllNum() {
        return adminDao.getAllNum();
    }
}
