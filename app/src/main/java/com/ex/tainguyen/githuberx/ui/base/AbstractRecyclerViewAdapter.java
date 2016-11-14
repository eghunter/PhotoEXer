package com.ex.tainguyen.githuberx.ui.base;

import android.support.v4.util.Pair;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

import rx.Observable;
import rx.subjects.PublishSubject;

/**
 * Created by tai.nguyen on 8/11/16.
 */

public abstract class AbstractRecyclerViewAdapter<D, VH extends AbstractRecycleViewViewHolder<D>>
        extends RecyclerView.Adapter<VH> {

    private final List<D> mValues;

    protected PublishSubject<Pair<Integer, D>> mItemClickCommand;

    public AbstractRecyclerViewAdapter() {
        this(new ArrayList<>());
    }

    public AbstractRecyclerViewAdapter(List<D> items) {
        mValues = items;
        mItemClickCommand = PublishSubject.create();
    }

    @Override
    public VH onCreateViewHolder(ViewGroup parent, int viewType) {
        return null;
    }

    @Override
    public int getItemCount() {
        return mValues.size();
    }

    @Override
    public void onBindViewHolder(VH holder, int position) {
        holder.bindData(getItem(position));
        holder.itemView
                .setOnClickListener(view ->
                        mItemClickCommand.onNext(
                                Pair.create(position, getItem(position))));
    }

    public D getItem(int position) {
        return mValues.get(position);
    }

    public List<D> setData(List<D> dataList) {
        if (mValues != null && mValues.size() > 0) {
            mValues.clear();
        }

        return addData(dataList);
    }

    public List<D> addData(List<D> dataList) {
        mValues.addAll(dataList);
        notifyDataSetChanged();

        return dataList;
    }

    public Observable<Pair<Integer, D>> onItemClickListener() {
        return mItemClickCommand.asObservable();
    }

    protected View getView(ViewGroup parent, int layId) {
        return LayoutInflater
                .from(parent.getContext())
                .inflate(layId, parent, false);
    }
}