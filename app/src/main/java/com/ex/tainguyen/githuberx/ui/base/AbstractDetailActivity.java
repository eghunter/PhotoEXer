package com.ex.tainguyen.githuberx.ui.base;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.ViewGroup;

import com.ex.tainguyen.githuberx.R;

public abstract class AbstractDetailActivity
        extends AppCompatActivity {

    protected abstract int getLayoutId();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_base_detail);
        Toolbar toolbar = (Toolbar) findViewById(R.id.detail_toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(view -> Snackbar.make(view,
                "Replace with your own detail action", Snackbar.LENGTH_LONG)
                .setAction("Action", null).show());

        // Show the Up button in the action bar.
        ActionBar actionBar = getSupportActionBar();
        if (actionBar != null) {
            actionBar.setDisplayHomeAsUpEnabled(true);
        }

        ViewGroup containLayout = (ViewGroup) findViewById(R.id.contain_layout);
        getLayoutInflater().inflate(getLayoutId(), containLayout);
    }
}
