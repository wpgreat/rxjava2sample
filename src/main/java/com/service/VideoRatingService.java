package com.service;

import com.model.Rating;
import com.model.Video;
import com.model.VideoRating;
import io.reactivex.Observable;
import io.reactivex.schedulers.Schedulers;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class VideoRatingService {

    private final RatingService ratingService;
    private final VideoService videoService;

    public VideoRatingService(RatingService ratingService, VideoService videoService) {
        this.ratingService = ratingService;
        this.videoService = videoService;
    }


    public List<VideoRating> getAllVideoRatings() {

        // rating service runs in separate thread
        Observable<List<Rating>> ratings = ratingService.getAllRatings()
                .subscribeOn(Schedulers.newThread())
                .onErrorReturn(throwable -> {
                    System.out.println("Error occurred returning empty rating list");
                    return new ArrayList<Rating>();
                });


        // video service runs in separate thread
        Observable<List<Video>> videos = videoService.getAllVideos()
                .subscribeOn(Schedulers.newThread())
                .onErrorReturn(throwable -> {
                    System.out.println("Error occurred returning empty video list");
                    return new ArrayList<Video>();
                });


        // rating data and video data combines to produce VideoRating data in blocking call
        return ratings.zipWith(videos, (List<Rating> ratings1, List<Video> videos1) -> {
            return ratings1.stream().map(rating -> {
                String videoName = videos1
                        .stream()
                        .filter(video -> rating.getVideoId() == video.getVideoId())
                        .findFirst()
                        .get()
                        .getName();
                return new VideoRating(rating.getRating(), rating.getVideoId(), videoName);
            }).collect(Collectors.toList());

        }).blockingSingle();
    }
}

