package com.mxd.video.service.impl;

import com.mxd.video.dao.UserDao;
import com.mxd.video.pojo.Category;
import com.mxd.video.pojo.History;
import com.mxd.video.pojo.Video;
import com.mxd.video.service.UserService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    @Resource
    private UserDao userDao;

    @Override
    public List<Category> getCategorys() {
        return userDao.getCategorys();
    }

    @Override
    public int subVideo(Video video) {
        return userDao.subVideo(video);
    }

    @Override
    public List<Video> getMyVideos(int userId) {
        return userDao.getMyVideos(userId);
    }

    @Override
    public List<History> getHistoryByVideoId(int videoId) {
        return userDao.getHistoryByVideoId(videoId);
    }

    @Override
    public List<Video> showAllVideos() {
        return userDao.showAllVideos();
    }

    @Override
    public int updatePhotoUrl(String photoUrl, int userId) {
        return userDao.updatePhotoUrl(photoUrl, userId);
    }
}
