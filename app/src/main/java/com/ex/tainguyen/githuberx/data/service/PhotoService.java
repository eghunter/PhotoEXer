package com.ex.tainguyen.githuberx.data.service;

import com.ex.tainguyen.githuberx.data.entity.photo.Photo;

import java.util.List;

import rx.Observable;

/**
 * Created by tai.nguyen on 10/6/16.
 */

public interface PhotoService {

    Observable<Photo> getUser(String photoId);

    Observable<List<Photo>> getUserList();
}
