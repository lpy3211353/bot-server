package com.lpy.bot.server.commons.util;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;

@Slf4j
public class BeanCopyUtils {

    public static <T> T copy(Object source, Class<T> type) {
        if (source == null) {
            return null;
        }
        T t;
        try {
            t = type.getDeclaredConstructor().newInstance();
        } catch (Exception e) {
            log.error("创建目标对象失败", e);
            throw new RuntimeException(e);
        }
        BeanUtils.copyProperties(source, t);
        return t;
    }
}
