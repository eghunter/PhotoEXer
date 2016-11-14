package com.ex.tainguyen.githuberx.ui.base;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.ViewGroup;
import android.widget.ProgressBar;

import com.ex.tainguyen.githuberx.R;

import static android.support.v4.app.NavUtils.navigateUpFromSameTask;

public abstract class AbstractActivity
        extends AppCompatActivity {

    protected FloatingActionButton fab;
    protected Toolbar toolbar;
    protected ProgressBar pbContentLoading;

    protected abstract int getLayoutId();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_base);

        toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        toolbar.setTitle(getTitle());

        fab = (FloatingActionButton) findViewById(R.id.fab);

        pbContentLoading = (ProgressBar) findViewById(R.id.pb_content_loading);

        //Init view stub
        ViewGroup replaceLayout = (ViewGroup) findViewById(R.id.replace_layout);
        getLayoutInflater().inflate(getLayoutId(), replaceLayout, true);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        if (id == android.R.id.home) {
            navigateUpFromSameTask(this);
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
}
