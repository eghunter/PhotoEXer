package com.ex.tainguyen.githuberx.di.modules;

import com.ex.tainguyen.githuberx.model.mapper.UserMapper;
import com.ex.tainguyen.githuberx.model.mapper.impl.UserMapperImpl;
import com.ex.tainguyen.githuberx.repository.GitHubUserRepository;
import com.ex.tainguyen.githuberx.repository.impl.GitHubUserRepositoryImpl;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

/**
 * Created by tai.nguyen on 10/6/16.
 */

@Module
public class RepositoryModule {

    @Singleton
    @Provides
    public GitHubUserRepository getGitHubUserRepository(GitHubUserRepositoryImpl repository) {
        return repository;
    }

    @Singleton
    @Provides
    public UserMapper getUserMapper(UserMapperImpl mapper) {
        return mapper;
    }
}
