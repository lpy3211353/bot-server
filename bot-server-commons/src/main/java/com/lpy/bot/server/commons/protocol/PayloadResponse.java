package com.lpy.bot.server.commons.protocol;

public class PayloadResponse<T> extends Response {
    private T data;

    public static <T> PayloadResponse<T> of(T data) {
        PayloadResponse<T> response = new PayloadResponse<>();
        response.setData(data);
        response.setToSuccess();
        return response;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }
}
