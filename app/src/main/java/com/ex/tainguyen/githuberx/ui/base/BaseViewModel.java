package com.ex.tainguyen.githuberx.ui.base;

import rx.Observable;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;
import rx.subscriptions.CompositeSubscription;

/**
 * Created by tai.nguyen on 10/27/16.
 */

public abstract class BaseViewModel<R>
        implements ViewModelLifeCycle{

    protected final CompositeSubscription mSubscription;

    protected final R mRepository;

    public BaseViewModel(R repository) {
        mRepository = repository;
        mSubscription = new CompositeSubscription();
    }

    public void unSubscribe() {
        mSubscription.clear();
    }

    protected <T> Observable.Transformer<T, T> applySchedules() {
        return tObservable -> tObservable
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread());
    }
}
