package com.ex.tainguyen.githuberx.ui.photo.adapter;

import android.view.View;
import android.view.ViewGroup;

import com.ex.tainguyen.githuberx.R;
import com.ex.tainguyen.githuberx.ui.base.AbstractRecycleViewViewHolder;
import com.ex.tainguyen.githuberx.ui.base.AbstractRecyclerViewAdapter;
import com.ex.tainguyen.githuberx.ui.photo.viewmodel.PhotoItemViewModel;

/**
 * Created by tai.nguyen on 11/6/16.
 */

public class PhotoAdapter
        extends AbstractRecyclerViewAdapter<PhotoItemViewModel, PhotoAdapter.ViewHolder> {

    public PhotoAdapter() {
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new ViewHolder(getView(parent, R.layout.item_view_photo_content));
    }

    public static class ViewHolder
            extends AbstractRecycleViewViewHolder<PhotoItemViewModel> {

        public ViewHolder(View view) {
            super(view);
        }
    }
}
