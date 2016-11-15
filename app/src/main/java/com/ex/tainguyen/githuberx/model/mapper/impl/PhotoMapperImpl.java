package com.ex.tainguyen.githuberx.model.mapper.impl;

import com.ex.tainguyen.githuberx.model.Photo;
import com.ex.tainguyen.githuberx.model.mapper.PhotoMapper;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

/**
 * Created by tai.nguyen on 10/6/16.
 */
public class PhotoMapperImpl
        extends BaseMapper
        implements PhotoMapper<com.ex.tainguyen.githuberx.data.entity.photo.Photo, Photo> {

    @Inject
    public PhotoMapperImpl() {
    }

    @Override
    public Photo transform(com.ex.tainguyen.githuberx.data.entity.photo.Photo photo) {
        checknull(photo);

        return new Photo(photo.getId()
                , photo.getColor()
                , photo.getLikes()
                , photo.getUrls().getRegular());
    }

    @Override
    public List<Photo> transform(List<com.ex.tainguyen.githuberx.data.entity.photo.Photo> photos) {
        checknull(photos);

        List<Photo> photoList = new ArrayList<>();
        for (final com.ex.tainguyen.githuberx.data.entity.photo.Photo photo : photos) {
            photoList.add(transform(photo));
        }

        return photoList;
    }

}
