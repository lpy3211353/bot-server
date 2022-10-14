package com.lpy.bot.server.client.demo.api;

import com.lpy.bot.server.client.demo.dto.PayloadDemoResp;
import com.lpy.bot.server.client.demo.dto.RegisterReq;

public interface DemoService {
    void register(RegisterReq req);

    PayloadDemoResp payloadDemo(String id);

    void domainDemo(RegisterReq req);
}
