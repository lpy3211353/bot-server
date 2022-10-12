package com.lpy.bot.server.domain.userinfo.service;

import com.lpy.bot.server.domain.userinfo.entity.UserInfoEntity;

public interface UserInfoDomain {
    boolean upsert(UserInfoEntity entity);
}
