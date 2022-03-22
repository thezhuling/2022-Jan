package com.zhuling.person.factory;

public class EmailSenderFactory implements SenderFactory {
    private EmailSenderFactory() {
    }

    private static volatile Sender emailSender;

    @Override
    public Sender getSender() {
        if (emailSender != null) {
            return emailSender;
        }

        synchronized (this) {
            if (emailSender == null) {
                emailSender = new EmailSender();
            }
            return emailSender;
        }
    }

    public static EmailSenderFactory getEmailSenderFactoryInstance() {
        return new EmailSenderFactory();
    }
}
