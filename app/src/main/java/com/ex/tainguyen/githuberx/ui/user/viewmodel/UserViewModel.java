package com.ex.tainguyen.githuberx.ui.user.viewmodel;

import android.databinding.ObservableField;

import com.ex.tainguyen.githuberx.model.User;
import com.ex.tainguyen.githuberx.ui.base.BaseViewModel;
import com.ex.tainguyen.githuberx.ui.user.GetUserDetail;

import javax.inject.Inject;

import rx.Observable;
import rx.subjects.PublishSubject;

/**
 * Created by tai.nguyen on 10/27/16.
 */

public class UserViewModel
        extends BaseViewModel<GetUserDetail> {

    public ObservableField<String> id = new ObservableField<>();
    public ObservableField<String> name = new ObservableField<>();

//    private final PublishSubject<Void> mUseLoadCommand = PublishSubject.create();
    private final PublishSubject<User> mPublishSubject = PublishSubject.create();

    @Inject
    public UserViewModel(GetUserDetail getUserDetail) {
        super(getUserDetail);

//        mUseLoadCommand
                getUser()
                .doOnNext(user -> id.set(user.getId()))
                .doOnNext(user -> name.set(user.getName()))
                .compose(applySchedules())
                .subscribe(mPublishSubject);
    }

    @Override
    public void subscribe() {
        mSubscription.add(mPublishSubject.subscribe());
    }

//    public void loadUser() {
//        mUseLoadCommand.onNext(null);
//    }

    private Observable<User> getUser() {
        return mRepository.getInfo();
    }
}
