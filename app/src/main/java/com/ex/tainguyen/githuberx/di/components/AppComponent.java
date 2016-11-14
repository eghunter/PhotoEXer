package com.ex.tainguyen.githuberx.di.components;

import com.ex.tainguyen.githuberx.data.service.GitHubService;
import com.ex.tainguyen.githuberx.di.modules.RepositoryModule;
import com.ex.tainguyen.githuberx.di.modules.ServiceModule;
import com.ex.tainguyen.githuberx.repository.GitHubUserRepository;

import javax.inject.Singleton;

import dagger.Component;

/**
 * Created by tai.nguyen on 10/6/16.
 */

@Singleton
@Component(modules = {
        ServiceModule.class
        , RepositoryModule.class
})
public interface AppComponent {
    GitHubService getGitHubService();

    GitHubUserRepository getGitHubUserRepository();
}
