package com.ex.tainguyen.githuberx.ui.photo.fragment;

import android.databinding.BindingAdapter;
import android.databinding.ObservableArrayList;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.ex.tainguyen.githuberx.R;
import com.ex.tainguyen.githuberx.di.components.UserComponent;
import com.ex.tainguyen.githuberx.ui.base.AbstractFragment;
import com.ex.tainguyen.githuberx.ui.base.AbstractRecyclerViewAdapter;
import com.ex.tainguyen.githuberx.ui.base.BaseViewModel;
import com.ex.tainguyen.githuberx.ui.photo.adapter.PhotoAdapter;
import com.ex.tainguyen.githuberx.ui.photo.viewmodel.PhotoItemViewModel;
import com.ex.tainguyen.githuberx.ui.photo.viewmodel.PhotoListViewModel;

import javax.inject.Inject;

import rx.Observable;
import rx.subjects.PublishSubject;

public class PhotoListFragment
        extends AbstractFragment {

    PublishSubject<String> mItemClickCommand = PublishSubject.create();

    @Inject
    PhotoListViewModel mViewModel;

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
        return R.layout.fragment_photo_list;
    }

    @Override
    public void initView(View view, Bundle savedInstanceState) {
        View recyclerView = view.findViewById(R.id.item_list);
        assert recyclerView != null;

        setupRecyclerView((RecyclerView) recyclerView);
    }

    @BindingAdapter({"bind:dataList"})
    public static void userDataBind(RecyclerView recyclerView
            , ObservableArrayList<PhotoItemViewModel> dataList) {
        if (dataList != null) {
            ((AbstractRecyclerViewAdapter) recyclerView.getAdapter()).addData(dataList);
        }
    }

    private void setupRecyclerView(@NonNull RecyclerView recyclerView) {
        PhotoAdapter adapter = new PhotoAdapter();
        /*adapter.onItemClickListener()
                .filter(dataPair -> dataPair != null && dataPair.second != null)
                .map(dataPair -> dataPair.second.id)
                .subscribe(mItemClickCommand::onNext);*/

//        recyclerView.setLayoutManager(
//                new StaggeredGridLayoutManager(2
//                        , StaggeredGridLayoutManager.VERTICAL));

        recyclerView.setAdapter(adapter);
    }

    public Observable<String> onItemClickListener() {
        return mItemClickCommand.asObservable();
    }
}
