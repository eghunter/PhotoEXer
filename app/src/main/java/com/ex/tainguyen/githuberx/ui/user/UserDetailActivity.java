package com.ex.tainguyen.githuberx.ui.user;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;

import com.ex.tainguyen.githuberx.AppApplication;
import com.ex.tainguyen.githuberx.R;
import com.ex.tainguyen.githuberx.di.HasComponent;
import com.ex.tainguyen.githuberx.di.components.DaggerUserComponent;
import com.ex.tainguyen.githuberx.di.components.UserComponent;
import com.ex.tainguyen.githuberx.di.modules.UserModule;

/**
 * An activity representing a single User detail screen. This
 * activity is only used narrow width devices. On tablet-size devices,
 * item details are presented side-by-side with a list of items
 * in a {@link UserListActivity}.
 */
public class UserDetailActivity
        extends AppCompatActivity
        implements HasComponent<UserComponent> {

    public static final String ARG_ITEM_ID = "ARG_ITEM_ID";
    UserComponent mUserComponent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_detail);

        mUserComponent = initComponent();

        Toolbar toolbar = (Toolbar) findViewById(R.id.detail_toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(view -> Snackbar.make(view, "Replace with your own detail action", Snackbar.LENGTH_LONG)
                .setAction("Action", null).show());

        // Show the Up button in the action bar.
        ActionBar actionBar = getSupportActionBar();
        if (actionBar != null) {
            actionBar.setDisplayHomeAsUpEnabled(true);
        }

        if (savedInstanceState == null) {
            // Create the detail fragment and add it to the activity
            // using a fragment transaction.
            Bundle arguments = new Bundle();
            arguments.putString(ARG_ITEM_ID,
                    getIntent().getStringExtra(ARG_ITEM_ID));
            UserDetailFragment fragment = new UserDetailFragment();
            fragment.setArguments(arguments);
            getSupportFragmentManager()
                    .beginTransaction()
                    .add(R.id.user_detail_container, fragment)
                    .commit();
        }
    }

    protected UserComponent initComponent() {
        return DaggerUserComponent.builder()
                .appComponent(((AppApplication) getApplication()).getComponent())
                .userModule(new UserModule(getIntent().getStringExtra(ARG_ITEM_ID)))
                .build();
    }

    @Override
    public UserComponent getComponent() {
        return mUserComponent;
    }
}
