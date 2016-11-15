package com.ex.tainguyen.githuberx.di.modules;

import com.ex.tainguyen.githuberx.data.api.API;
import com.ex.tainguyen.githuberx.data.net.ServiceGenerator;
import com.ex.tainguyen.githuberx.data.service.PhotoService;
import com.ex.tainguyen.githuberx.data.service.PhotoServiceImpl;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

/**
 * Created by tai.nguyen on 10/6/16.
 */

@Module
public class ServiceModule {

    @Singleton
    @Provides
    public API getGitHubClient() {
        return ServiceGenerator.createService(API.class);
    }

    @Singleton
    @Provides
    public PhotoService getGitHubService(PhotoServiceImpl service) {
        return service;
    }
}
