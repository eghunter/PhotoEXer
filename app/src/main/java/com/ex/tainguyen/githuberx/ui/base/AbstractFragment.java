package com.ex.tainguyen.githuberx.ui.base;

import android.databinding.DataBindingUtil;
import android.databinding.ViewDataBinding;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.ex.tainguyen.githuberx.BR;
import com.ex.tainguyen.githuberx.di.HasComponent;

public abstract class AbstractFragment
        extends Fragment
        implements FragLifeCycle {

    /**
     * The binding object instance.
     */
    protected ViewDataBinding mBinding;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        mBinding = DataBindingUtil
                .inflate(inflater
                        , getLayoutId()
                        , container
                        , false);

        return mBinding.getRoot();
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        mBinding.setVariable(BR.dataModel, getViewModel());

        initView(view, savedInstanceState);
    }

    @Override
    public void onResume() {
        super.onResume();

        getViewModel().subscribe();
    }

    @Override
    public void onPause() {
        super.onPause();

        getViewModel().unSubscribe();
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();

        mBinding.unbind();
    }

    protected abstract BaseViewModel getViewModel();

    protected <C> C getComponent(Class<C> componentType) {
        return componentType.cast(((HasComponent<C>) getActivity()).getComponent());
    }
}
