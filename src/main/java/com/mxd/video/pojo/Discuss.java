package com.mxd.video.pojo;


public class Discuss {
    private Integer id;
    private Integer videoId;
    private String userName;
    private String photoUrl;
    private String content;
    private String disTime;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getVideoId() {
        return videoId;
    }

    public void setVideoId(Integer videoId) {
        this.videoId = videoId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPhotoUrl() {
        return photoUrl;
    }

    public void setPhotoUrl(String photoUrl) {
        this.photoUrl = photoUrl;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getDisTime() {
        return disTime;
    }

    public void setDisTime(String disTime) {
        this.disTime = disTime;
    }
}
