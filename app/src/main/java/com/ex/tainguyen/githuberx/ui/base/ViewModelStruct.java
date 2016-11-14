package com.ex.tainguyen.githuberx.ui.base;

import android.support.v4.app.Fragment;

import com.ex.tainguyen.githuberx.di.components.LifeCycleInject;

/**
 * Created by tai.nguyen on 11/7/16.
 */
public interface ViewModelStruct {
    void inject(LifeCycleInject component, Fragment fragment);
}
