package com.zzb.notepad.bean;

/**
 * 作者： 张梓彬
 * 日期： 2017/9/16 0016
 * 时间： 下午 3:17
 * 描述： EventBus传递消息实体类
 */

public class EventBusMessage {
    private String msg;

    public EventBusMessage(String msg) {
        this.msg = msg;
    }

    public String getMsg() {
        return msg;
    }
}
