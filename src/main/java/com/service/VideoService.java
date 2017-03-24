package com.service;

import com.model.Video;
import io.reactivex.Observable;

import java.util.Arrays;
import java.util.List;

public class VideoService {

    public Observable<List<Video>> getAllVideos() {
        return Observable.create(observable -> {
            try {
                System.out.println(Thread.currentThread().getName());
                // this could be a slow rest / web service / io call
                // simulate slowness
                sleep(2);
                List<Video> videos = createVideos();
                observable.onNext(videos);
                observable.onComplete();
            } catch (Exception e) {
                observable.onError(e);
            }
        });
    }

    private List<Video> createVideos() {
        Video video1 = new Video(100, "Video 1");
        Video video2 = new Video(101, "Video 2");
        Video video3 = new Video(102, "Video 3");
        Video video4 = new Video(103, "Video 4");
        return Arrays.asList(video1, video2, video3, video4);
    }

    private void sleep(int second) {
        try {
            Thread.sleep(second * 1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

}
