package com.lpy.bot.server.infra.userinfo.gateway;

import com.baomidou.mybatisplus.core.conditions.update.LambdaUpdateWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.lpy.bot.server.domain.userinfo.entity.UserInfoEntity;
import com.lpy.bot.server.domain.userinfo.gateway.UserInfoGateway;
import com.lpy.bot.server.infra.userinfo.mapper.UserInfoMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class UserInfoGatewayImpl extends ServiceImpl<UserInfoMapper, UserInfoEntity>
        implements UserInfoGateway {

    @Override
    public boolean addUser(UserInfoEntity entity) {
        return save(entity);
    }

    @Override
    public UserInfoEntity queryById(String id) {
        return getById(id);
    }

    @Override
    public boolean updateById(UserInfoEntity entity) {
        return updateById(entity);
    }

    @Override
    public boolean updateByQqNumber(UserInfoEntity entity) {
        return update(entity,new LambdaUpdateWrapper<UserInfoEntity>()
                .ge(UserInfoEntity::getQqNumber,entity.getQqNumber()));
    }
}
