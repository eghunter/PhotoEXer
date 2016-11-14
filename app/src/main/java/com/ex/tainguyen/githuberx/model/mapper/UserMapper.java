package com.ex.tainguyen.githuberx.model.mapper;

import com.ex.tainguyen.githuberx.data.entity.UserEntity;
import com.ex.tainguyen.githuberx.model.User;

import java.util.List;

/**
 * Created by tai.nguyen on 10/27/16.
 */
public interface UserMapper {
    User transform(UserEntity entity);

    List<User> transform(List<UserEntity> entity);
}
