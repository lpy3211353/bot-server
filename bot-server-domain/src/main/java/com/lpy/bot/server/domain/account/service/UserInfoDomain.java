package com.lpy.bot.server.domain.account.service;

import com.lpy.bot.server.domain.account.bo.UserRegisterBo;
import com.lpy.bot.server.domain.account.entity.UserInfoEntity;

public interface UserInfoDomain {

    boolean register(UserRegisterBo bo);

    boolean upsert(UserInfoEntity entity);
}
