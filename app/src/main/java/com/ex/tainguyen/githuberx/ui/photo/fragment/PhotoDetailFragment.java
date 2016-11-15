package com.ex.tainguyen.githuberx.ui.photo.fragment;

import android.os.Bundle;
import android.view.View;

import com.ex.tainguyen.githuberx.R;
import com.ex.tainguyen.githuberx.di.components.UserComponent;
import com.ex.tainguyen.githuberx.ui.base.AbstractFragment;
import com.ex.tainguyen.githuberx.ui.base.BaseViewModel;
import com.ex.tainguyen.githuberx.ui.photo.viewmodel.PhotoViewModel;

import javax.inject.Inject;

import dagger.Lazy;

public class PhotoDetailFragment
        extends AbstractFragment {

    @Inject
    Lazy<PhotoViewModel> mModel;

    public PhotoDetailFragment() {
    }

    @Override
    public int getLayoutId() {
        return R.layout.fragment_photo_detail;
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
