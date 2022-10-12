package com.lpy.bot.server.client.demo.dto;

import lombok.*;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class DemoReq {
    private String id;
    private String qqNumber;
}
