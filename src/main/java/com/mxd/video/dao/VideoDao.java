package com.mxd.video.dao;

import com.mxd.video.pojo.Discuss;
import com.mxd.video.pojo.Video;

import java.util.List;

public interface VideoDao {

    public int isFavor(int videoId , int userId);
    public int favor(int videoId , int userId);
    public int cancelFavor(int videoId , int userId);

    public int isPraise(int videoId , int userId);
    public int praise(int videoId , int userId);
    public int addPraiseNum(int videoId);
    public int cancelPraise(int videoId , int userId);
    public int subPraiseNum(int videoId);

    public int addViewNum(int videoId);
    public int addHistory(int videoId , int userId);

    public List<Video> getCollectVideos(int userId);
    public List<Video> getPraiseVideos(int userId);
    public List<Video> getWatchVideos(int userId);

    public List<Discuss> checkVideoDiscusses(int videoId);
    public List<Video> checkDiscussedVideos(int userId);
    public int subDiscuss(int videoId , int userId , String content);

}
