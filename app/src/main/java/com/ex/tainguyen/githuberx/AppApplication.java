package com.ex.tainguyen.githuberx;

import android.app.Application;

import com.ex.tainguyen.githuberx.di.components.AppComponent;
import com.ex.tainguyen.githuberx.di.components.DaggerAppComponent;

/**
 * Created by tai.nguyen on 10/6/16.
 */

public class AppApplication extends Application {
    AppComponent mComponent;

    @Override
    public void onCreate() {
        super.onCreate();
        mComponent = DaggerAppComponent.builder()
                .build();
    }

    public AppComponent getComponent() {
        return mComponent;
    }
}
