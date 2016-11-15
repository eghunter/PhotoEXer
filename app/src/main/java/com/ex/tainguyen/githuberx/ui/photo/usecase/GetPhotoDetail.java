package com.ex.tainguyen.githuberx.ui.photo.usecase;

import com.ex.tainguyen.githuberx.model.Photo;
import com.ex.tainguyen.githuberx.repository.PhotoRepository;

import javax.inject.Inject;
import javax.inject.Named;

import rx.Observable;

/**
 * Created by tai.nguyen on 11/11/16.
 */

public class GetPhotoDetail {

    private final String id;

    private final PhotoRepository userRepository;

    @Inject
    public GetPhotoDetail(
            @Named("id") String id
            , PhotoRepository userRepository) {
        this.id = id;
        this.userRepository = userRepository;
    }

    public Observable<Photo> getInfo() {
        return userRepository.getUser(id);
    }
}
