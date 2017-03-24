package com.service;


import com.model.VideoRating;
import org.junit.Assert;
import org.junit.Test;

import java.util.List;

public class VideoRatingServiceTest {

    private final VideoRatingService videoRatingService
            = new VideoRatingService(new RatingService(), new VideoService());

    @Test
    public void shouldRetrieveVideoRatings() {
        List<VideoRating> videoRatings = videoRatingService.getAllVideoRatings();
        Assert.assertEquals(4, videoRatings.size());
    }
}
