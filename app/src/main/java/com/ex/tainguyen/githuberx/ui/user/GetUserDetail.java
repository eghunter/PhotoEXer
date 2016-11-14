package com.ex.tainguyen.githuberx.ui.user;

import com.ex.tainguyen.githuberx.model.User;
import com.ex.tainguyen.githuberx.repository.GitHubUserRepository;

import javax.inject.Inject;
import javax.inject.Named;

import rx.Observable;

/**
 * Created by tai.nguyen on 11/11/16.
 */

public class GetUserDetail {

    private final String userId;

    private final GitHubUserRepository userRepository;

    @Inject
    public GetUserDetail(
            @Named("userId") String userId
            , GitHubUserRepository userRepository) {
        this.userId = userId;
        this.userRepository = userRepository;
    }

    public Observable<User> getInfo() {
        return userRepository.getUser(userId);
    }
}
