package com.ex.tainguyen.githuberx.repository;

import com.ex.tainguyen.githuberx.model.User;

import java.util.List;

import rx.Observable;

/**
 * Created by tai.nguyen on 10/27/16.
 */

public interface GitHubUserRepository {

    Observable<User> getUser(String userName);

    Observable<List<User>> getUserList();
}
