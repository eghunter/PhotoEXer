package com.ex.tainguyen.githuberx.di.modules;

import com.ex.tainguyen.githuberx.model.mapper.PhotoMapper;
import com.ex.tainguyen.githuberx.model.mapper.impl.PhotoMapperImpl;
import com.ex.tainguyen.githuberx.repository.PhotoRepository;
import com.ex.tainguyen.githuberx.repository.impl.PhotoRepositoryImpl;

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
    public PhotoRepository getGitHubUserRepository(PhotoRepositoryImpl repository) {
        return repository;
    }

    @Singleton
    @Provides
    public PhotoMapper getUserMapper(PhotoMapperImpl mapper) {
        return mapper;
    }
}
