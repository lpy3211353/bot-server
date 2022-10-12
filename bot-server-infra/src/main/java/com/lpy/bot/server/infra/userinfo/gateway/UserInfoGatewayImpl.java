package com.lpy.bot.server.infra.userinfo.gateway;

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
    public boolean update(UserInfoEntity entity) {
        return updateById(entity);
    }
}
