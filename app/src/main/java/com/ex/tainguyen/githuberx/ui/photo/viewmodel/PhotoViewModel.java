package com.ex.tainguyen.githuberx.ui.photo.viewmodel;

import android.databinding.ObservableField;

import com.ex.tainguyen.githuberx.model.Photo;
import com.ex.tainguyen.githuberx.ui.base.BaseViewModel;
import com.ex.tainguyen.githuberx.ui.photo.usecase.GetPhotoDetail;

import javax.inject.Inject;

import rx.Observable;
import rx.subjects.PublishSubject;

/**
 * Created by tai.nguyen on 10/27/16.
 */

public class PhotoViewModel
        extends BaseViewModel<GetPhotoDetail> {

    public ObservableField<String> id = new ObservableField<>();
    public ObservableField<String> name = new ObservableField<>();

    private final PublishSubject<Photo> mPublishSubject = PublishSubject.create();

    @Inject
    public PhotoViewModel(GetPhotoDetail getPhotoDetail) {
        super(getPhotoDetail);

        getUser()
                .doOnNext(user -> id.set(user.getId()))
                .compose(applySchedules())
                .subscribe(mPublishSubject);
    }

    @Override
    public void subscribe() {
        mSubscription.add(mPublishSubject.subscribe());
    }

    private Observable<Photo> getUser() {
        return mUserCase.getInfo();
    }
}
