package com.lpy.bot.server.domain.userinfo.gateway;

import com.lpy.bot.server.domain.userinfo.entity.UserInfoEntity;

public interface UserInfoGateway {

    boolean addUser(UserInfoEntity entity);

    UserInfoEntity queryById(String id);

    boolean updateById(UserInfoEntity entity);

    boolean updateByQqNumber(UserInfoEntity entity);
}
