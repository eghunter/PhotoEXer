package com.ex.tainguyen.githuberx.di.components;

import com.ex.tainguyen.githuberx.data.service.PhotoService;
import com.ex.tainguyen.githuberx.di.modules.RepositoryModule;
import com.ex.tainguyen.githuberx.di.modules.ServiceModule;
import com.ex.tainguyen.githuberx.repository.PhotoRepository;

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
    PhotoService getGitHubService();

    PhotoRepository getGitHubUserRepository();
}
