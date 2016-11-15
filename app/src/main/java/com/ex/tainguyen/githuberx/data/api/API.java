package com.ex.tainguyen.githuberx.data.api;

import com.ex.tainguyen.githuberx.config.APIConfig;
import com.ex.tainguyen.githuberx.data.entity.photo.Photo;

import java.util.List;

import retrofit2.Response;
import retrofit2.http.GET;
import retrofit2.http.Headers;
import retrofit2.http.Path;
import rx.Observable;

/**
 * Created by tai.nguyen on 10/6/16.
 */
public interface API {

    @Headers({
            APIConfig.API_HEADER_ACCEPT_VERSION,
            APIConfig.API_HEADER_CLIENT_ID + " " + APIConfig.API_CLIENT_ID})
    @GET("photos")
    Observable<Response<List<Photo>>> getPhotoList();

    @Headers({
            APIConfig.API_HEADER_ACCEPT_VERSION,
            APIConfig.API_HEADER_CLIENT_ID + " " + APIConfig.API_CLIENT_ID})
    @GET("photos/:{id}")
    Observable<Response<Photo>> getPhoto(@Path("id") String photoId);
}
