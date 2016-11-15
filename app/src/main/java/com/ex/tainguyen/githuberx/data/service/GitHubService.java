package com.ex.tainguyen.githuberx.data.service;

import com.ex.tainguyen.githuberx.data.entity.UserEntity;

import java.util.List;

import rx.Observable;

/**
 * Created by tai.nguyen on 10/6/16.
 */

public interface GitHubService {

    Observable<UserEntity> getUser(String userName);

    Observable<List<UserEntity>> getUserList();
}
