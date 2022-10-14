package com.lpy.bot.server.infra.userinfo.gateway;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.lpy.bot.server.commons.security.HashUtil;
import com.lpy.bot.server.domain.account.entity.GroupInfoEntity;
import com.lpy.bot.server.domain.account.gateway.GroupInfoGateway;
import com.lpy.bot.server.infra.userinfo.mapper.GroupInfoMapper;
import org.springframework.stereotype.Component;

@Component
public class GroupInfoGatewayImpl extends ServiceImpl<GroupInfoMapper, GroupInfoEntity>
        implements GroupInfoGateway {

    @Override
    public GroupInfoEntity queryByGroupNumber(String groupNumber) {
        return getOne(new LambdaQueryWrapper<GroupInfoEntity>().
                eq(GroupInfoEntity::getGroupNumber, HashUtil.toSha256(groupNumber)));
    }

    @Override
    public boolean save(GroupInfoEntity entity) {
        return super.save(entity);
    }
}
