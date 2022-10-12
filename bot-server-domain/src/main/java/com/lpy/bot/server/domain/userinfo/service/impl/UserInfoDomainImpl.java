package com.lpy.bot.server.domain.userinfo.service.impl;

import com.lpy.bot.server.domain.shortmsg.ShortMsgGateway;
import com.lpy.bot.server.domain.userinfo.entity.UserInfoEntity;
import com.lpy.bot.server.domain.userinfo.gateway.UserInfoGateway;
import com.lpy.bot.server.domain.userinfo.service.UserInfoDomain;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@RequiredArgsConstructor
@Service
public class UserInfoDomainImpl implements UserInfoDomain {

    private final UserInfoGateway userInfoGateway;

    private final ShortMsgGateway shortMsgGateway;

    @Override
    public boolean upsert(UserInfoEntity entity) {
        if (!userInfoGateway.addUser(entity)) {
            return userInfoGateway.update(entity);
        }
        shortMsgGateway.mockSendMsg();
        return true;
    }
}