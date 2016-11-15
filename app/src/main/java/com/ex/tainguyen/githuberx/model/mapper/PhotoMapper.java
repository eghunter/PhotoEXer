package com.ex.tainguyen.githuberx.model.mapper;

import java.util.List;

/**
 * Created by tai.nguyen on 10/27/16.
 */
public interface PhotoMapper<F, T> {
    T transform(F f);

    List<T> transform(List<F> fList);
}
