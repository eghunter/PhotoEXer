package com.ex.tainguyen.githuberx.data.api;

import com.ex.tainguyen.githuberx.data.entity.UserEntity;

import java.util.List;

import retrofit2.Response;
import retrofit2.http.GET;
import retrofit2.http.Path;
import rx.Observable;

/**
 * Created by tai.nguyen on 10/6/16.
 */

public interface GitHubClient {

    @GET("/users")
    Observable<Response<List<UserEntity>>> getUserList();

    @GET("/users/{username}")
    Observable<Response<UserEntity>> getUser(@Path("username") String userName);
}
