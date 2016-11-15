package com.ex.tainguyen.githuberx.ui.utils;

import android.databinding.BindingAdapter;
import android.widget.ImageView;

import com.bumptech.glide.Glide;

/**
 * Created by tai.nguyen on 11/14/16.
 */

public class ImageBindingUtils {
    @BindingAdapter("app:imageUrl")
    public static void loadImage(ImageView view, String url) {
        Glide.with(view.getContext()).load(url).into(view);
    }
}
