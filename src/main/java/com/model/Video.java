package com.model;


public class Video {

    private final int videoId;
    private final String name;

    public Video(int videoId, String name) {
        this.videoId = videoId;
        this.name = name;
    }

    public int getVideoId() {
        return videoId;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return "Video{" +
                "videoId=" + videoId +
                ", name='" + name + '\'' +
                '}';
    }
}
