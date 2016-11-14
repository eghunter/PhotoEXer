package com.ex.tainguyen.githuberx.di.modules;

import com.ex.tainguyen.githuberx.data.api.GitHubClient;
import com.ex.tainguyen.githuberx.data.net.ServiceGenerator;
import com.ex.tainguyen.githuberx.data.service.GitHubService;
import com.ex.tainguyen.githuberx.data.service.GitHubServiceImpl;

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
    public GitHubClient getGitHubClient() {
        return ServiceGenerator.createService(GitHubClient.class);
    }

    @Singleton
    @Provides
    public GitHubService getGitHubService(GitHubServiceImpl service) {
        return service;
    }
}
