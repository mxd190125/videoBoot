package com.mxd.video.service;

import com.mxd.video.pojo.Category;
import com.mxd.video.pojo.History;
import com.mxd.video.pojo.Video;

import java.util.List;

public interface UserService {

    public List<Category> getCategorys();

    public int subVideo(Video video);

    public List<Video> getMyVideos(int userId);

    public List<History> getHistoryByVideoId(int videoId);

    public List<Video> showAllVideos();

    public int updatePhotoUrl(String photoUrl , int userId);

}
