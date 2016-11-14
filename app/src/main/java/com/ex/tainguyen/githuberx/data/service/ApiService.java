package com.ex.tainguyen.githuberx.data.service;

import retrofit2.Response;
import rx.Observable;

/**
 * Created by tai.nguyen on 10/6/16.
 */

public class ApiService {
    protected <T> Observable<T> catchError(Response<T> response) {
        return Observable.create(subscriber -> {
            if (response.isSuccessful()) {
                subscriber.onNext(response.body());
                subscriber.onCompleted();
            } else {
                subscriber.onError(new Throwable(response.message()));
            }
        });
    }
}
