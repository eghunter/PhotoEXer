package com.ex.tainguyen.githuberx.model.mapper.impl;

/**
 * Created by tai.nguyen on 10/6/16.
 */
public class BaseMapper {

    <E> E checknull(E e) {
        if (e == null) {
            throw new IllegalArgumentException("Object null");
        }

        return e;
    }
}
