package com.lpy.bot.server.domain.account.gateway;

import com.lpy.bot.server.domain.account.entity.GroupInfoEntity;

public interface GroupInfoGateway {
    boolean save(GroupInfoEntity entity);

    GroupInfoEntity queryByGroupNumber(String groupNumber);
}
