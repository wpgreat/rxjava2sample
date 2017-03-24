package com.model;


public class VideoRating {

    private final int rating;
    private final int videoId;
    private final String name;

    public VideoRating(int rating, int videoId, String name) {
        this.rating = rating;
        this.videoId = videoId;
        this.name = name;
    }

    public int getRating() {
        return rating;
    }

    public int getVideoId() {
        return videoId;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return "VideoRating{" +
                "rating=" + rating +
                ", videoId=" + videoId +
                ", name='" + name + '\'' +
                '}';
    }
}
