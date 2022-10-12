package com.lpy.bot.server.infra.shortmsg;

import com.lpy.bot.server.domain.shortmsg.ShortMsgGateway;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
@Slf4j
public class ShortMsgGatewayImpl implements ShortMsgGateway {
    @Override
    public void mockSendMsg() {
      log.info("发送短信！");
    }
}
