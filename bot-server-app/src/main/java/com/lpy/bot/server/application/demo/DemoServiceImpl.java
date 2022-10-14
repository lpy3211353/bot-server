package com.lpy.bot.server.application.demo;

import com.lpy.bot.server.client.demo.api.DemoService;
import com.lpy.bot.server.client.demo.dto.RegisterReq;
import com.lpy.bot.server.client.demo.dto.PayloadDemoResp;
import com.lpy.bot.server.commons.enums.DemoEnum;
import com.lpy.bot.server.commons.security.HashUtil;
import com.lpy.bot.server.commons.util.BeanCopyUtils;
import com.lpy.bot.server.domain.shortmsg.ShortMsgGateway;
import com.lpy.bot.server.domain.account.entity.UserInfoEntity;
import com.lpy.bot.server.domain.account.gateway.UserInfoGateway;
import com.lpy.bot.server.domain.account.service.UserInfoDomain;
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
    public void register(RegisterReq req) {

        shortMsgGateway.mockSendMsg();
    }

    @Override
    public PayloadDemoResp payloadDemo(String id) {
        UserInfoEntity entity = userInfoGateway.queryById(id);
        PayloadDemoResp resp=BeanCopyUtils.copy(entity, PayloadDemoResp.class);
        resp.setDemoEnum(DemoEnum.DEMO1);
        return resp;
    }

    @Override
    public void domainDemo(RegisterReq req) {

    }
}
