package com.lpy.bot.server.client.demo.dto;

import com.lpy.bot.server.commons.enums.DemoEnum;
import lombok.*;

import java.util.Date;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class PayloadDemoResp {

    private String id;

    private byte[] qqNumber;

    private DemoEnum demoEnum;

    private Date createTime;

    private String updateTime;
}
