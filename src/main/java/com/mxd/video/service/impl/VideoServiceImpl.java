package com.mxd.video.service.impl;


import com.mxd.video.dao.VideoDao;
import com.mxd.video.pojo.Category;
import com.mxd.video.pojo.Discuss;
import com.mxd.video.pojo.Video;
import com.mxd.video.service.VideoService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

@Service
public class VideoServiceImpl implements VideoService {

    @Resource
    private VideoDao videoDao;


    @Override
    public int isFavor(int videoId, int userId) {
        return videoDao.isFavor(videoId, userId);
    }

    @Override
    public int favor(int videoId, int userId) {
        return videoDao.favor(videoId, userId);
    }

    @Override
    public int cancelFavor(int videoId, int userId) {
        return videoDao.cancelFavor(videoId, userId);
    }

    @Override
    public int isPraise(int videoId, int userId) {
        return videoDao.isPraise(videoId, userId);
    }

    @Override
    public int praise(int videoId, int userId) {
        int i = videoDao.praise(videoId, userId);
        int j = videoDao.addPraiseNum(videoId);
        return i != 0 && j != 0 ? 1 : 0;
    }


    @Override
    public int cancelPraise(int videoId, int userId) {
        int i = videoDao.cancelPraise(videoId, userId);
        int j = videoDao.subPraiseNum(videoId);
        return i != 0 && j != 0 ? 1 : 0;
    }

    @Override
    public int addViewNum(int videoId , int userId) {
        int i = videoDao.addViewNum(videoId);

        int j = videoDao.addHistory(videoId, userId);
        return i > 0 && j > 0 ? 1 : 0;
    }


    @Override
    public List<Video> getCollectVideos(int userId) {
        return videoDao.getCollectVideos(userId);
    }

    @Override
    public List<Video> getPraiseVideos(int userId) {
        return videoDao.getPraiseVideos(userId);
    }

    @Override
    public List<Video> getWatchVideos(int userId) {
        List<Video> videos = videoDao.getWatchVideos(userId);
        List<Video> videos1 = new ArrayList<>();
        // 去掉同样的视频，保留最近看的视频
        HashSet<Integer> set = new HashSet<>();
        for (Video video : videos) {
            if (!set.contains(video.getId())){
                videos1.add(video);
                set.add(video.getId());
            }
        }
        return videos1;
    }

    @Override
    public List<Discuss> checkVideoDiscusses(int videoId) {
        return videoDao.checkVideoDiscusses(videoId);
    }

    @Override
    public List<Video> checkDiscussedVideos(int userId) {
        return videoDao.checkDiscussedVideos(userId);
    }

    @Override
    public int subDiscuss(int videoId, int userId, String content) {
        return videoDao.subDiscuss(videoId, userId, content);
    }


}
