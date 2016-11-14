package com.ex.tainguyen.githuberx.ui.user;

import android.databinding.BindingAdapter;
import android.databinding.ObservableArrayList;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.ex.tainguyen.githuberx.R;
import com.ex.tainguyen.githuberx.di.components.UserComponent;
import com.ex.tainguyen.githuberx.ui.base.AbstractFragment;
import com.ex.tainguyen.githuberx.ui.base.AbstractRecyclerViewAdapter;
import com.ex.tainguyen.githuberx.ui.base.BaseViewModel;
import com.ex.tainguyen.githuberx.ui.user.viewmodel.UserItemViewModel;
import com.ex.tainguyen.githuberx.ui.user.viewmodel.UserListViewModel;

import javax.inject.Inject;

import rx.Observable;
import rx.subjects.PublishSubject;

public class UserListFragment
        extends AbstractFragment {

    PublishSubject mItemClickCommand = PublishSubject.create();

    @Inject
    UserListViewModel mViewModel;

    @Override
    protected BaseViewModel getViewModel() {
        return mViewModel;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getComponent(UserComponent.class)
                .inject(this);
    }

    @Override
    public int getLayoutId() {
        return R.layout.fragment_user_list;
    }

    @Override
    public void initView(View view, Bundle savedInstanceState) {
        View recyclerView = view.findViewById(R.id.user_list);
        assert recyclerView != null;

        setupRecyclerView((RecyclerView) recyclerView);
    }

    @BindingAdapter({"bind:dataList"})
    public static void userDataBind(RecyclerView recyclerView
            , ObservableArrayList<UserItemViewModel> dataList) {
        if (recyclerView.getLayoutManager() == null) {
            recyclerView.setLayoutManager(new LinearLayoutManager(recyclerView.getContext()));
        }

        if (dataList != null) {
            ((AbstractRecyclerViewAdapter) recyclerView.getAdapter()).addData(dataList);
        }
    }

    private void setupRecyclerView(@NonNull RecyclerView recyclerView) {
        SimpleItemRecyclerViewAdapter adapter = new SimpleItemRecyclerViewAdapter();
        adapter.onItemClickListener()
                .subscribe(dataPair -> mItemClickCommand.onNext(dataPair.second.name.get()));

        recyclerView.setAdapter(adapter);
    }

    public Observable<String> onItemClickListener() {
        return mItemClickCommand.asObservable();
    }
}
