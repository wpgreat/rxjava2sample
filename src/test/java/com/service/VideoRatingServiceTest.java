package com.service;


import com.model.VideoRating;
import io.reactivex.Observable;
import io.reactivex.ObservableEmitter;
import io.reactivex.ObservableOnSubscribe;
import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;
import org.junit.Assert;
import org.junit.Test;

import java.util.List;

public class VideoRatingServiceTest {

    private final VideoRatingService videoRatingService
            = new VideoRatingService(new RatingService(), new VideoService());

    @Test
    public void testGetAllVideoRatings() {
        List<VideoRating> videoRatings = videoRatingService.getAllVideoRatings();
        Assert.assertEquals(4, videoRatings.size());
    }

    @Test
    public void testBase() {
        // 创建一个上游 Observable
        Observable<Integer> observable = Observable.create(new ObservableOnSubscribe<Integer>() {
            @Override
            public void subscribe(ObservableEmitter<Integer> emitter) throws Exception {
                emitter.onNext(1);
                emitter.onNext(2);
                emitter.onNext(3);
                emitter.onComplete();
                emitter.onError(new Throwable("Error occurred!"));
                emitter.onNext(4);
                emitter.onNext(5);
            }
        });
        // 创建一个下游 Observer
        Observer<Integer> observer = new Observer<Integer>() {
            @Override
            public void onSubscribe(Disposable d) {
                System.out.println("onSubscribe");
            }

            @Override
            public void onNext(Integer integer) {
                System.out.println("onNext:" + integer);
            }

            @Override
            public void onError(Throwable e) {
                System.out.println("onError:" + e.getMessage());
            }

            @Override
            public void onComplete() {
                System.out.println("onComplete");
            }
        };
        // 建立连接
        observable.subscribe(observer);
    }
}
