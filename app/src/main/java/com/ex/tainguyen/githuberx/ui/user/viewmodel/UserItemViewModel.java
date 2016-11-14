package com.ex.tainguyen.githuberx.ui.user.viewmodel;

import android.databinding.ObservableField;

/**
 * Created by tai.nguyen on 10/27/16.
 */

public class UserItemViewModel {
    public ObservableField<String> id = new ObservableField<>();
    public ObservableField<String> name = new ObservableField<>();

    public UserItemViewModel(String id, String name) {
        this.id.set(id);
        this.name.set(name);
    }
}
