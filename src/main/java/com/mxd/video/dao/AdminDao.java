package com.mxd.video.dao;

import com.mxd.video.pojo.Category;
import com.mxd.video.pojo.User;
import com.mxd.video.pojo.Video;

import java.util.List;

public interface AdminDao {

    public int isExist(String name);

    public int addCateName(String name);

    public List<Category> showAllCateName();

    public List<User> showUsersByPage(int page);

    public int getPageNum();

    public int delUser(String username);

    public int modPass(String username, String newPass);



    public List<Video> checkVideosByVideoName(String videoName, int page);

    public List<Video> checkVideosByCateName(String cateName, int page);

    public List<Video> checkVideosByVCName(String videoName, String cateName, int page);

    public List<Video> checkAllVideos(int page);



    public int getVNameNum(String videoName);

    public int getCNameNum(String cateName);

    public int getVCNameNum(String videoName, String cateName);

    public int getAllNum();

}
