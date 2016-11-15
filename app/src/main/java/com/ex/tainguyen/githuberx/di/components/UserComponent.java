package com.ex.tainguyen.githuberx.di.components;

import com.ex.tainguyen.githuberx.di.AScope;
import com.ex.tainguyen.githuberx.di.modules.PhotoModule;
import com.ex.tainguyen.githuberx.ui.photo.fragment.PhotoDetailFragment;
import com.ex.tainguyen.githuberx.ui.photo.fragment.PhotoListFragment;

import dagger.Component;

/**
 * Created by tai.nguyen on 10/6/16.
 */

@AScope
@Component(
        dependencies = {AppComponent.class}
        , modules = {PhotoModule.class})
public interface UserComponent {
    void inject(PhotoDetailFragment fragment);

    void inject(PhotoListFragment userListActivity);
}
