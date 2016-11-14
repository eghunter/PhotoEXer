package com.ex.tainguyen.githuberx.ui.base;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.ViewGroup;

import com.ex.tainguyen.githuberx.R;

public abstract class AbstractDetailActivity
        extends AppCompatActivity {

    protected FloatingActionButton fab;
    protected Toolbar toolbar;

    protected abstract int getLayoutId();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_base_detail);
        toolbar = (Toolbar) findViewById(R.id.detail_toolbar);
        setSupportActionBar(toolbar);

        fab = (FloatingActionButton) findViewById(R.id.fab);

        // Show the Up button in the action bar.
        ActionBar actionBar = getSupportActionBar();
        if (actionBar != null) {
            actionBar.setDisplayHomeAsUpEnabled(true);
        }

        ViewGroup replaceLayout = (ViewGroup) findViewById(R.id.replace_layout);
        getLayoutInflater().inflate(getLayoutId(), replaceLayout, true);
    }
}
