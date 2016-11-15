package com.ex.tainguyen.githuberx.repository;

import com.ex.tainguyen.githuberx.model.Photo;

import java.util.List;

import rx.Observable;

/**
 * Created by tai.nguyen on 10/27/16.
 */

public interface PhotoRepository {

    Observable<Photo> getUser(String photoId);

    Observable<List<Photo>> getUserList();
}
