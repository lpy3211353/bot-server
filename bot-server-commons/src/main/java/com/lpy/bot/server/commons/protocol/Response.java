package com.lpy.bot.server.commons.protocol;

import lombok.*;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Response {
    private String retCode;
    private String retMsg;

    public static Response creatSuccess() {
        Response response = new Response();
        response.setToSuccess();
        return response;
    }

    public void setToSuccess() {
        this.retCode = "100";
        this.retMsg = "success!";
    }
}
