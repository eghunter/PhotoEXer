package com.ex.tainguyen.githuberx.ui.photo.activity;

import android.content.Intent;
import android.os.Bundle;

import com.ex.tainguyen.githuberx.AppApplication;
import com.ex.tainguyen.githuberx.R;
import com.ex.tainguyen.githuberx.di.HasComponent;
import com.ex.tainguyen.githuberx.di.components.DaggerUserComponent;
import com.ex.tainguyen.githuberx.di.components.UserComponent;
import com.ex.tainguyen.githuberx.di.modules.PhotoModule;
import com.ex.tainguyen.githuberx.ui.base.AbstractActivity;
import com.ex.tainguyen.githuberx.ui.photo.fragment.PhotoDetailFragment;
import com.ex.tainguyen.githuberx.ui.photo.fragment.PhotoListFragment;

public class PhotoListActivity
        extends AbstractActivity
        implements HasComponent<UserComponent> {

    private boolean mTwoPane = false;

    UserComponent userComponent;

    @Override
    protected int getLayoutId() {
        return R.layout.activity_photo_list;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        userComponent = initComponent();

        mTwoPane = findViewById(R.id.user_detail_container) != null;

        if (savedInstanceState == null) {
            PhotoListFragment fragment = new PhotoListFragment();
            fragment.onItemClickListener()
                    .subscribe(name -> openItem(name, mTwoPane));

            getSupportFragmentManager()
                    .beginTransaction()
                    .add(R.id.contain_layout, fragment)
                    .commit();
        }
    }

    private UserComponent initComponent() {
        return DaggerUserComponent.builder()
                .appComponent(((AppApplication) getApplication()).getComponent())
                .photoModule(new PhotoModule(""))
                .build();
    }


    @Override
    public UserComponent getComponent() {
        return userComponent;
    }

    private String openItem(String name, boolean isTwoPanel) {
        if (isTwoPanel) {
            Bundle arguments = new Bundle();
            arguments.putString(PhotoDetailActivity.ARG_ITEM_ID, name);
            PhotoDetailFragment fragment = new PhotoDetailFragment();
            fragment.setArguments(arguments);

            getSupportFragmentManager().beginTransaction()
                    .replace(R.id.user_detail_container, fragment)
                    .commit();
        } else {
            Intent intent = new Intent(this, PhotoDetailActivity.class);
            intent.putExtra(PhotoDetailActivity.ARG_ITEM_ID, name);

            this.startActivity(intent);
        }

        return name;
    }
}
