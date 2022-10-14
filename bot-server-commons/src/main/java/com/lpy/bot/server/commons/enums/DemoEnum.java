package com.lpy.bot.server.commons.enums;

import com.baomidou.mybatisplus.annotation.EnumValue;
import com.fasterxml.jackson.annotation.JsonValue;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum DemoEnum {

    DEMO1(1, "测试1"),
    DEMO2(2, "测试2");


    @EnumValue
    private final Integer value;

    private final String desc;

    @JsonValue
    public Integer getValue() {
        return value;
    }

    public String getDesc() {
        return desc;
    }
}
