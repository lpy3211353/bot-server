package com.lpy.bot.server.adapter.user;

import com.lpy.bot.server.client.demo.api.DemoService;
import com.lpy.bot.server.client.demo.dto.PayloadDemoResp;
import com.lpy.bot.server.client.demo.dto.RegisterReq;
import com.lpy.bot.server.commons.protocol.PayloadResponse;
import com.lpy.bot.server.commons.protocol.Response;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user")
@RequiredArgsConstructor
public class UserController {

    private final DemoService demoService;


    @PostMapping("/register")
    public Response demo(@RequestBody RegisterReq req) {
        demoService.register(req);
        return Response.creatSuccess();
    }

    @PostMapping("/payload")
    public PayloadResponse<PayloadDemoResp> payloadResponseDemo(@RequestBody RegisterReq req) {
        PayloadDemoResp resp = demoService.payloadDemo(req.getId());
        return PayloadResponse.of(resp);
    }
}
