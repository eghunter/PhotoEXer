package com.ex.tainguyen.githuberx.ui.photo.viewmodel;

import android.databinding.ObservableField;

/**
 * Created by tai.nguyen on 10/27/16.
 */

public class PhotoItemViewModel {
    public ObservableField<String> url = new ObservableField<>();
    public String id;

    public PhotoItemViewModel(String id
            , String url) {
        this.id = id;
        this.url.set(url);
    }
}
