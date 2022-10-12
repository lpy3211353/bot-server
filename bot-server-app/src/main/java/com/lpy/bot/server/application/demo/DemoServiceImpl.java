package com.lpy.bot.server.application.demo;

import com.lpy.bot.server.client.demo.api.DemoService;
import com.lpy.bot.server.client.demo.dto.DemoReq;
import com.lpy.bot.server.client.demo.dto.PayloadDemoResp;
import com.lpy.bot.server.commons.security.HashUtil;
import com.lpy.bot.server.commons.util.BeanCopyUtils;
import com.lpy.bot.server.domain.shortmsg.ShortMsgGateway;
import com.lpy.bot.server.domain.userinfo.entity.UserInfoEntity;
import com.lpy.bot.server.domain.userinfo.gateway.UserInfoGateway;
import com.lpy.bot.server.domain.userinfo.service.UserInfoDomain;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

// 服务编排
@Service
@RequiredArgsConstructor
public class DemoServiceImpl implements DemoService {

    private final UserInfoGateway userInfoGateway;

    private final ShortMsgGateway shortMsgGateway;

    private final UserInfoDomain userInfoDomain;

    @Override
    public void demo(DemoReq req) {
        UserInfoEntity userInfoEntity = UserInfoEntity.builder()
                .qqNumber(HashUtil.toSha256(req.getQqNumber()))
                .build();
        userInfoEntity.generatorUuid();
        userInfoGateway.addUser(userInfoEntity);
        shortMsgGateway.mockSendMsg();
    }

    @Override
    public PayloadDemoResp payloadDemo(String id) {
        UserInfoEntity entity = userInfoGateway.queryById(id);
        return BeanCopyUtils.copy(entity, PayloadDemoResp.class);
    }

    @Override
    public void domainDemo(DemoReq req) {
        UserInfoEntity entity = UserInfoEntity.builder()
                .qqNumber(HashUtil.toSha256(req.getQqNumber()))
                .build();
        entity.generatorUuid();
        userInfoDomain.upsert(entity);
    }
}
