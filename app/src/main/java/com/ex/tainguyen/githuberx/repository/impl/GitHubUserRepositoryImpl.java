package com.ex.tainguyen.githuberx.repository.impl;

import com.ex.tainguyen.githuberx.data.service.GitHubService;
import com.ex.tainguyen.githuberx.model.User;
import com.ex.tainguyen.githuberx.model.mapper.UserMapper;
import com.ex.tainguyen.githuberx.repository.GitHubUserRepository;

import java.util.List;

import javax.inject.Inject;

import rx.Observable;

/**
 * Created by tai.nguyen on 10/27/16.
 */
public class GitHubUserRepositoryImpl
        implements GitHubUserRepository {

    private final GitHubService mService;
    private final UserMapper mMapper;

    private List<User> mCache;

    @Inject
    public GitHubUserRepositoryImpl(
            GitHubService service
            , UserMapper mapper) {
        mService = service;
        mMapper = mapper;
    }


    @Override
    public Observable<User> getUser(String userName) {
        return mService.getUser(userName)
                .map(mMapper::transform);
    }

    @Override
    public Observable<List<User>> getUserList() {
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
