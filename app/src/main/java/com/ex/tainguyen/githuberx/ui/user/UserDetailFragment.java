package com.ex.tainguyen.githuberx.ui.user;

import android.os.Bundle;
import android.view.View;

import com.ex.tainguyen.githuberx.R;
import com.ex.tainguyen.githuberx.di.components.UserComponent;
import com.ex.tainguyen.githuberx.ui.base.AbstractFragment;
import com.ex.tainguyen.githuberx.ui.base.BaseViewModel;
import com.ex.tainguyen.githuberx.ui.user.viewmodel.UserViewModel;

import javax.inject.Inject;

import dagger.Lazy;

public class UserDetailFragment
        extends AbstractFragment {

    @Inject
    Lazy<UserViewModel> mModel;

    public UserDetailFragment() {
    }

    @Override
    public int getLayoutId() {
        return R.layout.fragment_user_detail;
    }

    @Override
    public void initView(View view, Bundle savedInstanceState) {
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        getComponent(UserComponent.class)
                .inject(this);
    }

    @Override
    protected BaseViewModel getViewModel() {
        return mModel.get();
    }
}
