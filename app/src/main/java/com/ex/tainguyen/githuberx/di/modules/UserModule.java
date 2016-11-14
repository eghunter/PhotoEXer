package com.ex.tainguyen.githuberx.di.modules;

import com.ex.tainguyen.githuberx.di.AScope;

import javax.inject.Named;

import dagger.Module;
import dagger.Provides;

/**
 * Created by tai.nguyen on 11/11/16.
 */

@Module
public class UserModule {
    String id;

    public UserModule() {
        this.id = "";
    }

    public UserModule(String id) {
        this.id = id;
    }

    @Provides
    @AScope
    @Named("userId")
    public String getUserId(){
        return id;
    }

    /*@Provides
    @AScope
    public GetUserDetail getUserDetail(GetUserDetail getUserDetail){
        return getUserDetail;
    }*/
}
