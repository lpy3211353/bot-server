package com.lpy.bot.server.commons.protocol;

import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import lombok.*;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class)
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
