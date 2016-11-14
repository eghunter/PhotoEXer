package com.ex.tainguyen.githuberx.ui.user.viewmodel;

import android.databinding.ObservableArrayList;

import com.ex.tainguyen.githuberx.model.User;
import com.ex.tainguyen.githuberx.repository.GitHubUserRepository;
import com.ex.tainguyen.githuberx.ui.base.BaseViewModel;

import java.util.List;

import javax.inject.Inject;

import rx.Observable;
import rx.subjects.PublishSubject;

/**
 * Created by tai.nguyen on 10/27/16.
 */

public class UserListViewModel
        extends BaseViewModel<GitHubUserRepository> {

    private final PublishSubject<List<UserItemViewModel>> mUserListResult = PublishSubject.create();

    public ObservableArrayList<UserItemViewModel> itemList;

    @Inject
    public UserListViewModel(GitHubUserRepository repository) {
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

    private Observable<List<UserItemViewModel>> getUserList() {
        return mRepository.getUserList()
                .flatMap(Observable::from)
                .map(this::transform)
                .toList();
    }

    private UserItemViewModel transform(User user) {
        return new UserItemViewModel(
                user.getId()
                , user.getName());
    }
}
