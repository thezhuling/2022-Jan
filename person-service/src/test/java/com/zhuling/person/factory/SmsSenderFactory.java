package com.zhuling.person.factory;

public class SmsSenderFactory implements SenderFactory {
    private static volatile Sender smsSender = null;

    private SmsSenderFactory() {
    }

    @Override
    public Sender getSender() {
        if (smsSender != null) {
            return smsSender;
        }

        synchronized (this) {
            if (smsSender == null) {
                smsSender = new SmsSender();
            }
        }
        return smsSender;
    }

    public static SmsSenderFactory getSmsSenderFactoryInstance() {
        return new SmsSenderFactory();
    }
}
