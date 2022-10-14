package com.lpy.bot.server.client.demo.api;

import com.lpy.bot.server.client.demo.dto.RegisterReq;
import com.lpy.bot.server.client.demo.dto.PayloadDemoResp;

public interface DemoService {
    void register(RegisterReq req);

    PayloadDemoResp payloadDemo(String id);

    void domainDemo(RegisterReq req);
}
