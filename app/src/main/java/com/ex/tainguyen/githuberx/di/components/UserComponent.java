package com.ex.tainguyen.githuberx.di.components;

import com.ex.tainguyen.githuberx.di.AScope;
import com.ex.tainguyen.githuberx.di.modules.UserModule;
import com.ex.tainguyen.githuberx.ui.user.UserDetailFragment;
import com.ex.tainguyen.githuberx.ui.user.UserListActivity;
import com.ex.tainguyen.githuberx.ui.user.UserListFragment;

import dagger.Component;

/**
 * Created by tai.nguyen on 10/6/16.
 */

@AScope
@Component(
        dependencies = {AppComponent.class}
        , modules = {UserModule.class})
public interface UserComponent {
    void inject(UserDetailFragment fragment);

    void inject(UserListFragment userListActivity);
}
