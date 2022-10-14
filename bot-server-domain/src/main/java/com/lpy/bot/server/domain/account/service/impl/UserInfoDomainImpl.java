package com.lpy.bot.server.domain.account.service.impl;

import com.lpy.bot.server.commons.security.HashUtil;
import com.lpy.bot.server.domain.account.bo.UserRegisterBo;
import com.lpy.bot.server.domain.account.entity.GroupInfoEntity;
import com.lpy.bot.server.domain.account.entity.UserInfoEntity;
import com.lpy.bot.server.domain.account.gateway.GroupInfoGateway;
import com.lpy.bot.server.domain.account.gateway.UserInfoGateway;
import com.lpy.bot.server.domain.account.service.UserInfoDomain;
import com.lpy.bot.server.domain.shortmsg.ShortMsgGateway;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Slf4j
@RequiredArgsConstructor
@Service
public class UserInfoDomainImpl implements UserInfoDomain {

    private final UserInfoGateway userInfoGateway;

    private final GroupInfoGateway groupInfoGateway;
    private final ShortMsgGateway shortMsgGateway;

    @Transactional(rollbackFor = Throwable.class)
    @Override
    public boolean register(UserRegisterBo bo) {
        GroupInfoEntity groupInfo = groupInfoGateway.queryByGroupNumber(bo.getGroupNumber());
        if (groupInfo == null) {
            // todo 异常处理
            log.error("group is null!");
            return false;
        }
        UserInfoEntity userInfo = UserInfoEntity.builder()
                .qqNumber(HashUtil.toSha256(bo.getQqNumber()))
                .groupSerial(groupInfo.getId())
                .build();
        userInfo.generatorUuid();
        return userInfoGateway.addUser(userInfo);
    }

    @Override
    public boolean upsert(UserInfoEntity entity) {
        try {
            userInfoGateway.addUser(entity);
        } catch (DuplicateKeyException e) {
            userInfoGateway.updateByQqNumber(entity);
            shortMsgGateway.mockSendMsg();
        }
        return true;
    }
}
