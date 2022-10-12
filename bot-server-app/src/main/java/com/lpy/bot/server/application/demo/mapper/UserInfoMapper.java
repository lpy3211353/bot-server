package com.lpy.bot.server.application.demo.mapper;

import com.lpy.bot.server.client.demo.dto.PayloadDemoResp;
import com.lpy.bot.server.domain.userinfo.entity.UserInfoEntity;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface UserInfoMapper {
    UserInfoMapper INSTANCE = Mappers.getMapper(UserInfoMapper.class);

    PayloadDemoResp from(UserInfoEntity entity);
}
