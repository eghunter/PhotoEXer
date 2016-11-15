package com.ex.tainguyen.githuberx.repository.impl;

import com.ex.tainguyen.githuberx.data.service.PhotoService;
import com.ex.tainguyen.githuberx.model.Photo;
import com.ex.tainguyen.githuberx.model.mapper.PhotoMapper;
import com.ex.tainguyen.githuberx.repository.PhotoRepository;

import java.util.List;

import javax.inject.Inject;

import rx.Observable;

/**
 * Created by tai.nguyen on 10/27/16.
 */
public class PhotoRepositoryImpl
        implements PhotoRepository {

    private final PhotoService mService;
    private final PhotoMapper<com.ex.tainguyen.githuberx.data.entity.photo.Photo, Photo> mMapper;

    private List<Photo> mCache;

    @Inject
    public PhotoRepositoryImpl(
            PhotoService service
            , PhotoMapper mapper) {
        mService = service;
        mMapper = mapper;
    }


    @Override
    public Observable<Photo> getUser(String photoId) {
        return mService.getUser(photoId)
                .map(mMapper::transform);
    }

    @Override
    public Observable<List<Photo>> getUserList() {
        return Observable
                .concat(mCache != null
                                ? Observable.just(mCache)
                                : Observable.empty()
                        , mService
                                .getUserList()
                                .map(mMapper::transform)
                                .doOnNext(users -> mCache = users))
                .first();
    }
}
