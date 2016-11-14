package com.ex.tainguyen.githuberx.ui.base;

import android.databinding.DataBindingUtil;
import android.databinding.ViewDataBinding;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.ex.tainguyen.githuberx.BR;

/**
 * Created by tai.nguyen on 8/11/16.
 */
public abstract class AbstractRecycleViewViewHolder<M>
        extends RecyclerView.ViewHolder {

    public ViewDataBinding mDataBinding;

    public AbstractRecycleViewViewHolder(View itemView) {
        super(itemView);
        mDataBinding = DataBindingUtil.bind(itemView);
    }

    public M bindData(M m){
        mDataBinding.setVariable(BR.item, m);
        mDataBinding.executePendingBindings();

        return m;
    }
}
