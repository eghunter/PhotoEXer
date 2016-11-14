package com.ex.tainguyen.githuberx.ui.user;

import android.view.View;
import android.view.ViewGroup;

import com.ex.tainguyen.githuberx.R;
import com.ex.tainguyen.githuberx.ui.base.AbstractRecycleViewViewHolder;
import com.ex.tainguyen.githuberx.ui.base.AbstractRecyclerViewAdapter;
import com.ex.tainguyen.githuberx.ui.user.viewmodel.UserItemViewModel;

/**
 * Created by tai.nguyen on 11/6/16.
 */

public class SimpleItemRecyclerViewAdapter
        extends AbstractRecyclerViewAdapter<UserItemViewModel, SimpleItemRecyclerViewAdapter.ViewHolder> {

    public SimpleItemRecyclerViewAdapter() {
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new ViewHolder(getView(parent, R.layout.user_list_content));
    }

    public class ViewHolder
            extends AbstractRecycleViewViewHolder<UserItemViewModel> {

        public ViewHolder(View view) {
            super(view);
        }
    }
}
