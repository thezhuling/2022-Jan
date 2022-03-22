package com.zhuling.person.factory;

public class SmsSender implements Sender {
    @Override
    public String sendMessage() {
        System.out.println("send sms");
        return "ok";
    }
}
