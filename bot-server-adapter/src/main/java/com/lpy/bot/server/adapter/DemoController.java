package com.lpy.bot.server.adapter;

import com.lpy.bot.server.client.demo.api.DemoService;
import com.lpy.bot.server.client.demo.dto.DemoReq;
import com.lpy.bot.server.client.demo.dto.PayloadDemoResp;
import com.lpy.bot.server.commons.protocol.PayloadResponse;
import com.lpy.bot.server.commons.protocol.Response;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/demo")
@RequiredArgsConstructor
public class DemoController {

    private final DemoService demoService;


    @PostMapping("/demo")
    public Response demo(@RequestBody DemoReq req) {
        demoService.demo(req);
        return Response.creatSuccess();
    }

    @PostMapping("/payload")
    public PayloadResponse<PayloadDemoResp> payloadResponseDemo(@RequestBody DemoReq req) {
        return PayloadResponse.of(demoService.payloadDemo(req.getId()));
    }

    @PostMapping("/domain")
    public Response domainDemo(@RequestBody DemoReq req) {
        demoService.domainDemo(req);
        return Response.creatSuccess();
    }
}
