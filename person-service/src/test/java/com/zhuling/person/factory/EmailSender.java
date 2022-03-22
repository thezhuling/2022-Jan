package com.zhuling.person.factory;

public class EmailSender implements Sender {
    @Override
    public String sendMessage() {
        System.out.println("send email");
        return "ok";
    }
}
