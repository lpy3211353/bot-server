package com.lpy.bot.server.client.demo.api;

import com.lpy.bot.server.client.demo.dto.DemoReq;
import com.lpy.bot.server.client.demo.dto.PayloadDemoResp;

public interface DemoService {
    void demo(DemoReq req);

    PayloadDemoResp payloadDemo(String id);

    void domainDemo(DemoReq req);
}
