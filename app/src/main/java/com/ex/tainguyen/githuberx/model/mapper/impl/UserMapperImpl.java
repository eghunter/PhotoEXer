package com.ex.tainguyen.githuberx.model.mapper.impl;

import com.ex.tainguyen.githuberx.data.entity.UserEntity;
import com.ex.tainguyen.githuberx.model.User;
import com.ex.tainguyen.githuberx.model.mapper.UserMapper;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

/**
 * Created by tai.nguyen on 10/6/16.
 */
public class UserMapperImpl
        extends BaseMapper
        implements UserMapper {

    @Inject
    public UserMapperImpl() {
    }

    @Override
    public User transform(UserEntity entity) {
        checknull(entity);

        return new User(
                String.valueOf(entity.getId())
                , entity.getLogin());
    }

    @Override
    public List<User> transform(List<UserEntity> entities) {
        List<User> userList = new ArrayList<>();

        for (final UserEntity entity : entities) {
            userList.add(transform(entity));
        }

        return userList;
    }
}
