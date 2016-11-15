package com.ex.tainguyen.githuberx.data.service;

import com.ex.tainguyen.githuberx.data.api.API;
import com.ex.tainguyen.githuberx.data.entity.photo.Photo;

import java.util.List;

import javax.inject.Inject;

import rx.Observable;
import rx.schedulers.Schedulers;

/**
 * Created by tai.nguyen on 10/6/16.
 */

public class PhotoServiceImpl
        extends ApiService
        implements PhotoService {

    private final API mClient;

    @Inject
    public PhotoServiceImpl(API API) {
        mClient = API;
    }

    @Override
    public Observable<List<Photo>> getUserList() {
        return mClient.getPhotoList()
                .flatMap(this::catchError)
                .subscribeOn(Schedulers.io());
    }

    @Override
    public Observable<Photo> getUser(String photoId) {
        return mClient.getPhoto(photoId)
                .flatMap(this::catchError)
                .subscribeOn(Schedulers.io());
    }
}
