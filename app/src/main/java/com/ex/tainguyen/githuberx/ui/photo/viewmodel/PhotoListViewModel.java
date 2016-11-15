package com.ex.tainguyen.githuberx.ui.photo.viewmodel;

import android.databinding.ObservableArrayList;

import com.ex.tainguyen.githuberx.model.Photo;
import com.ex.tainguyen.githuberx.repository.PhotoRepository;
import com.ex.tainguyen.githuberx.ui.base.BaseViewModel;

import java.util.List;

import javax.inject.Inject;

import rx.Observable;
import rx.subjects.PublishSubject;

/**
 * Created by tai.nguyen on 10/27/16.
 */

public class PhotoListViewModel
        extends BaseViewModel<PhotoRepository> {

    private final PublishSubject<List<PhotoItemViewModel>> mUserListResult = PublishSubject.create();

    public ObservableArrayList<PhotoItemViewModel> itemList;

    @Inject
    public PhotoListViewModel(PhotoRepository repository) {
        super(repository);
        itemList = new ObservableArrayList<>();

        getUserList()
                .doOnNext(itemList::addAll)
                .compose(applySchedules())
                .subscribe(mUserListResult);
    }

    @Override
    public void subscribe() {
        mSubscription.add(mUserListResult.subscribe());
    }

    private Observable<List<PhotoItemViewModel>> getUserList() {
        return mUserCase.getUserList()
                .flatMap(Observable::from)
                .map(this::transform)
                .toList();
    }

    private PhotoItemViewModel transform(Photo photo) {
        return new PhotoItemViewModel(photo.getId(), photo.getUrl());
    }
}
