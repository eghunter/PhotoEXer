package com.ex.tainguyen.githuberx.ui.base;

import android.os.Bundle;
import android.view.View;

/**
 * Created by tai.nguyen on 10/6/16.
 */
public interface FragLifeCycle {
    int getLayoutId();

    void initView(View view, Bundle savedInstanceState);
}
