package com.ex.tainguyen.githuberx.data.service;

import com.ex.tainguyen.githuberx.data.api.GitHubClient;
import com.ex.tainguyen.githuberx.data.entity.UserEntity;

import java.util.List;

import javax.inject.Inject;

import rx.Observable;
import rx.schedulers.Schedulers;

/**
 * Created by tai.nguyen on 10/6/16.
 */

public class GitHubServiceImpl
        extends ApiService
        implements GitHubService {

    private final GitHubClient mClient;

    @Inject
    public GitHubServiceImpl(GitHubClient gitHubClient) {
        mClient = gitHubClient;
    }

    @Override
    public Observable<List<UserEntity>> getUserList() {
        return mClient.getUserList()
                .flatMap(this::catchError)
                .subscribeOn(Schedulers.io());
    }

    @Override
    public Observable<UserEntity> getUser(String userName) {
        return mClient.getUser(userName)
                .flatMap(this::catchError)
                .subscribeOn(Schedulers.io());
    }
}
