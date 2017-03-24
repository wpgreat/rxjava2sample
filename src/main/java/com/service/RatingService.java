package com.service;


import com.model.Rating;
import io.reactivex.Observable;

import java.util.Arrays;
import java.util.List;

public class RatingService {

    public Observable<List<Rating>> getAllRatings() {
        return Observable.create(observable -> {
            try {

                System.out.println(Thread.currentThread().getName());
                // this could be a slow rest / web service / io call
                // simulate slowness
                sleep(4);
                List<Rating> ratings = createRatings();
                observable.onNext(ratings);
                observable.onComplete();
            } catch (Exception e) {
                observable.onError(e);
            }
        });

    }

    private void sleep(int second) {
        try {
            Thread.sleep(second * 1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    private List<Rating> createRatings() {
        Rating rating1 = new Rating(5, 100);
        Rating rating2 = new Rating(4, 101);
        Rating rating3 = new Rating(3, 102);
        Rating rating4 = new Rating(1, 103);
        return Arrays.asList(rating1, rating2, rating3, rating4);
    }
}
