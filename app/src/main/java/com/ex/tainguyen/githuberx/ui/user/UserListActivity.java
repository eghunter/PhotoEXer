package com.ex.tainguyen.githuberx.ui.user;

import android.content.Intent;
import android.os.Bundle;

import com.ex.tainguyen.githuberx.AppApplication;
import com.ex.tainguyen.githuberx.R;
import com.ex.tainguyen.githuberx.di.HasComponent;
import com.ex.tainguyen.githuberx.di.components.DaggerUserComponent;
import com.ex.tainguyen.githuberx.di.components.UserComponent;
import com.ex.tainguyen.githuberx.di.modules.UserModule;
import com.ex.tainguyen.githuberx.ui.base.AbstractActivity;

public class UserListActivity
        extends AbstractActivity
        implements HasComponent<UserComponent> {

    private boolean mTwoPane = false;

    UserComponent userComponent;

    @Override
    protected int getLayoutId() {
        return R.layout.activity_user_list;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        userComponent = initComponent();

        mTwoPane = findViewById(R.id.user_detail_container) != null;

        if (savedInstanceState == null) {
            UserListFragment fragment = new UserListFragment();
            fragment.onItemClickListener()
                    .subscribe(name -> {
                        if (mTwoPane) {
                            Bundle arguments = new Bundle();
                            arguments.putString(UserDetailActivity.ARG_ITEM_ID, name);
                            UserDetailFragment userDetailFragment = new UserDetailFragment();
                            fragment.setArguments(arguments);
                            getSupportFragmentManager().beginTransaction()
                                    .replace(R.id.user_detail_container, userDetailFragment)
                                    .commit();
                        } else {
                            Intent intent = new Intent(this, UserDetailActivity.class);
                            intent.putExtra(UserDetailActivity.ARG_ITEM_ID, name);

                            this.startActivity(intent);
                        }
                    });

            getSupportFragmentManager()
                    .beginTransaction()
                    .add(R.id.contain_layout, new UserListFragment())
                    .commit();
        }
    }

    private UserComponent initComponent() {
        return DaggerUserComponent.builder()
                .appComponent(((AppApplication) getApplication()).getComponent())
                .userModule(new UserModule(""))
                .build();
    }


    @Override
    public UserComponent getComponent() {
        return userComponent;
    }
}
