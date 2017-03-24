package com.model;


public class Rating {

    private final int rating;
    private final int videoId;

    public Rating(int rating, int videoId) {
        this.rating = rating;
        this.videoId = videoId;
    }

    public int getRating() {
        return rating;
    }

    public int getVideoId() {
        return videoId;
    }

    @Override
    public String toString() {
        return "Rating{" +
                "rating=" + rating +
                ", videoId=" + videoId +
                '}';
    }
}
